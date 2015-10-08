package com.copart.Enity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
	private int id;
	private String name;
	private String country;

	// constructors

	protected Member() {
	}

	public Member(int id) {
		setId(id);
	}

	// getters

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	// setters

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return id + "\n" + name + "\n" + country + "\n";
	}

}
