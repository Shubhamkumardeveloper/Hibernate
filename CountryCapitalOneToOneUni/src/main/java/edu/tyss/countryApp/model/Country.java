package edu.tyss.countryApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Country {
	@Id
	private int id;
	private String name;
	@OneToOne
	private State states;
	
	public Country()
	{}

	public Country(int id, String name, State states) {
		super();
		this.id = id;
		this.name = name;
		this.states = states;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public State getStates() {
		return states;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStates(State states) {
		this.states = states;
	}
	
}
