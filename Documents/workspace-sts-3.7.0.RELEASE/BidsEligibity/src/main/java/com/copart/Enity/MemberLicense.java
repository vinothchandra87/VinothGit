package com.copart.Enity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MemberLicense {

	@Id
	private int id;
	@Id
	private String licenseType;
	private Date expirationDate;

	// constructors

	protected MemberLicense() {
	}

	public MemberLicense(int id) {
		setId(id);
	}

	// getters

	public int getId() {
		return id;
	}

	public String licenseType() {
		return licenseType;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	// setters

	public void setId(int id) {
		this.id = id;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return id + "\n" + licenseType + "\n" + expirationDate + "\n";
	}
}
