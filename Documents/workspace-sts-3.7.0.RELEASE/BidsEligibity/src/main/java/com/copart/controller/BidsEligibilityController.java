package com.copart.controller;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.copart.Enity.*;
import com.copart.Repository.*;

@Controller
//@RequestMapping("/")
public class BidsEligibilityController {

	private boolean memberElgibility;

	private LotRepository lotRep;
	private MemberRepository memberRep;
	private MemberLicenseRepository memberLicenseRep;

	private List<MemberLicense> allMemberLicenses;
	private List<Lot> allLots;
	private List<Member> allMembers;

	private int lotID;
	private int memID;

	private Lot currentLot;
	private Member currentMember;
	private MemberLicense currentMemberLicense;

	private Model model;
	private String BidEligible;

	// setters
	public void setMemberEligibility(boolean memberEligibility) {
		this.memberElgibility = memberEligibility;
	}

	public void setLotRep(Lot lotRep) {
		this.lotRep.save(lotRep);
	}

	public void setMemberRep(Member memberRep) {
		this.memberRep.save(memberRep);
	}

	public void setMemberLicenseRep(MemberLicense memberLicenseRep) {
		this.memberLicenseRep.save(memberLicenseRep);
	}

	public void setAllLots(List<Lot> allLots) {
		this.allLots = allLots;
	}

	public void setAllMembers(List<Member> allMembers) {
		this.allMembers = allMembers;
	}

	public void setAllMemberLicenses(List<MemberLicense> allMemberLicenses) {
		this.allMemberLicenses = allMemberLicenses;
	}

	public void setLotID(int lotID) {
		this.lotID = lotID;
	}

	public void setMemID(int memID) {
		this.memID = memID;
	}

	public void setCurrentLot(Lot currentLot) {
		this.currentLot = currentLot;
	}

	public void setCurrentMember(Member currentMember) {
		this.currentMember = currentMember;
	}

	public void setCurrentMemberLicense(MemberLicense currentMemberLicense) {
		this.currentMemberLicense = currentMemberLicense;
	}
	
	public void setModel(Model model)
	{
		this.model = model;
	}
	public void setBidEligible(String BidEligible)
	{
		this.BidEligible = BidEligible;
	}

	// getters
	public boolean getMemberEligibility() {
		return memberElgibility;
	}

	public LotRepository getLotRep() {
		return lotRep;
	}

	public MemberRepository getMemberRep() {
		return memberRep;
	}

	public MemberLicenseRepository getMemberLicenseRep() {
		return memberLicenseRep;
	}

	public List<Lot> getAllLots() {
		return allLots;
	}

	public List<Member> getAllMembers() {
		return allMembers;
	}

	public List<MemberLicense> getAllMemberLicenses() {
		return allMemberLicenses;
	}

	public int getLotID() {
		return lotID;
	}

	public int getMemID() {
		return memID;
	}

	public Lot getCurrentLot() {
		return currentLot;
	}

	public Member getCurrentMember() {
		return currentMember;
	}

	public MemberLicense getCurrentMemberLicense() {
		return currentMemberLicense;
	}

	public Model getModer()
	{
		return model;
	}
	public String getBidEligible()
	{
		return BidEligible;
	}
	
 @RequestMapping("/")
	 public String index() {
		 	System.out.println("hello");
	        return "BidsEligibility";
	    }
	
	@RequestMapping(value = "/BidsEligibilities", method = RequestMethod.GET)
	public String BidsEligibity(@RequestParam(value = "lotId") String strLotId,
			@RequestParam(value = "memId") String strMemId, Model currModel) {
		// String BidEligible = "";

		model = currModel;

		if (isInputValid(strLotId, strMemId))
			return "BidsEligibility";

		setValues(strLotId, strMemId);

		if (isLotAndMemberValid())
			return "BidsEligibility";

		isMemberEligible();

		if (memberElgibility) {
			model.addAttribute("This member is eligible for the bid", BidEligible);
			return "BidsEligibility";
		}

		model.addAttribute("This member is NOT eligible for the bid", BidEligible);
		return "BidsEligibility";

	}

	public boolean isInputValid(String strLotId, String strMemId) {
		// if input is empty or null returns appropriate message
		if (strLotId.equals("") && strMemId.equals("") || strLotId.equals(null) && strMemId.equals(null)) {
			model.addAttribute("Enter values for MemID & LotID", BidEligible);
			return true;

		}
		if (strLotId.equals("") || strLotId.equals(null)) {
			model.addAttribute("Enter value for LotID", BidEligible);
			return true;

		}
		if (strMemId.equals("") || strMemId.equals(null)) {
			model.addAttribute("Enter value for MemberID", BidEligible);
			return true;
		}
		return false;
	}

	public boolean isLotAndMemberValid() {
		// checking if valid customer

		if (allLots.size() <= 0 && allMembers.size() <= 0) {
			model.addAttribute("Not a Valid Lot ID & MemberID", BidEligible);
			return true;
		}
		if (allLots.size() <= 0) {
			model.addAttribute("Not a Valid Lot ID", BidEligible);
			return true;
		}
		if (allMembers.size() <= 0) {
			model.addAttribute("Not a Valid Member ID", BidEligible);
			return true;
		}
		return false;
	}

	public void setValues(String strLotId, String strMemId) {
		lotID = Integer.parseInt(strLotId);
		memID = Integer.parseInt(strMemId);

		lotRep.save(new Lot(lotID));
		memberRep.save(new Member(memID));
		memberLicenseRep.save(new MemberLicense(memID));

		allLots = lotRep.findById(lotID);
		allMembers = memberRep.findById(memID);
		allMemberLicenses = memberLicenseRep.findById(memID);

		currentLot = allLots.get(0);
		currentMember = allMembers.get(0);
	}

	public void isMemberEligible() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		try {

			kSession.insert(this);
			kSession.fireAllRules();

		} catch (Throwable t) {
			System.out.println("Error:" + t.getMessage());
		} finally {
			kSession.dispose();
		}

	}

}
