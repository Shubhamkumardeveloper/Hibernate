package edu.tyss.countryApp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
	
	private long id;
	private String name;
	@Id
	private String CountryCode;
	private String countryLanguage;
	@OneToMany
	List<State> states;
	
	public Country() {}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public String getCountryLanguage() {
		return countryLanguage;
	}

	public List<State> getStates() {
		return states;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public void setCountryLanguage(String countryLanguage) {
		this.countryLanguage = countryLanguage;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", CountryCode=" + CountryCode + ", countryLanguage="
				+ countryLanguage + ", states=" + states + "]";
	}
	
}
