package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class SampleDroolsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "vinoth";
		String address = "2400 waterview pkwy,Apt 1023,Dallas,Texas,Spain,75252";
		String LicenseType = "IAEDismantler";
		String saleDocumentType = "Scrap";

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		try {
			Buyer newBuyer = null;

			newBuyer = new Buyer(name, LicenseType, address, saleDocumentType);

			kSession.insert(newBuyer);

			kSession.fireAllRules();
		} catch (Throwable t) {
			System.out.println("Error:" + t.getMessage());
		} finally {
			kSession.dispose();
		}

	}
}
