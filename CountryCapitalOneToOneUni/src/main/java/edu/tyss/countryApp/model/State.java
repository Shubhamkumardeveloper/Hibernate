package edu.tyss.countryApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {
	@Id
	private int id;
	private String name;
	private int country_id;
	
	public State()
	{}

	public State(int id, String name, int country_id) {
		this.id = id;
		this.name = name;
		this.country_id = country_id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
}
