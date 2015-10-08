package com.copart.Enity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lot {

	@Id
	private int id;
	private String country;
	private String documentType;
	private int year;
	private String make;
	private String model;
	private String damage;

	protected Lot() {
	}

	public Lot(int id) {
		setLotNumber(id);
	}

	// getters

	public int getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public String getDocumentType() {
		return documentType;
	}

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getDamage() {
		return damage;
	}

	// setters

	public void setLotNumber(int id) {
		this.id = id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return (id + "\n" + country + "\n" + documentType + "\n" + year + "\n" + make + "\n" + model + "\n" + damage
				+ "\n");

	}

}
