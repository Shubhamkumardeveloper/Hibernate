package edu.tyss.State_Country;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class State {
	@Id
	private int id;
	private String name;
	private String language;
	
	@ManyToOne
	private Country country;
	
	public State() {
	}

	public State(int id, String name, String language) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	public Country getCountry() {
		return country;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", language=" + language + ", country=" + country + "]";
	}
	
	
	

}
