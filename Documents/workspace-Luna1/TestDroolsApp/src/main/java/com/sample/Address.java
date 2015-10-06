package com.sample;

public class Address {

	private String line1;
	private String line2;
	private String city;
	private String state;
	private String country;
	private int zipcode;

	// setters
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	// getters
	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country.toLowerCase();
	}

	public int getZipcode() {
		return zipcode;
	}

	// assumption that each features of address in separated buy a comma (,)
	// character
	public Address(String address) {
		String[] splitAddress = address.split(",");

		int size = splitAddress.length - 1;
		this.setLine1(splitAddress[0]);
		if (size - 4 == 1) {
			this.setLine2(splitAddress[size - 4]); // check if line 2 of address
													// field exists
		}
		this.setCity(splitAddress[size - 3]);
		this.setState(splitAddress[size - 2]);
		this.setCountry(splitAddress[size - 1]);
		this.setZipcode(Integer.parseInt(splitAddress[size]));

		// System.out.println(getCountry());

	}

	@Override
	public String toString() {
		return (this.getLine1() + "\n" + this.getLine2() + "\n"
				+ this.getCity() + "\n" + this.getState() + "\n"
				+ this.getCountry() + "\n" + this.getZipcode());
	}

}
