/**
 * 
 */
package com.sample;

/**
 * @author vinothchandrasekar
 *
 */
public class Buyer {

	private String buyerName;
	private String licenseType;
	private Address addressOfBuyer;
	private String saleDocumentType;

	// getters

	public String getBuyerName() {
		return this.buyerName.toLowerCase();
	}

	public String getLicenseType() {
		return this.licenseType.toLowerCase();
	}

	public Address getAddressOfBuyer() {
		// String returnAddress = addressOfBuyer;
		return this.addressOfBuyer;
	}

	public String getSaleDocumentType() {
		return this.saleDocumentType.toLowerCase();
	}

	// setters

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public void setLincesceType(String licenseType) {
		this.licenseType = licenseType;
	}

	public void setAddressOfBuyer(String address) {
		this.addressOfBuyer = new Address(address);
	}

	public void setSaleDocumentType(String saleDocumentType) {
		this.saleDocumentType = saleDocumentType;
	}

	public Buyer(String buyerName, String licenseType, String address,
			String saleDocumentType) {
		// TODO Auto-generated constructor stub
		this.setBuyerName(buyerName);
		this.setLincesceType(licenseType);
		this.setAddressOfBuyer(address);
		this.setSaleDocumentType(saleDocumentType);

		// System.out.println(buyerName + "\n" + licenseType + "\n" +
		// addressOfBuyer + "\n" + saleDocumentType);

	}

}
