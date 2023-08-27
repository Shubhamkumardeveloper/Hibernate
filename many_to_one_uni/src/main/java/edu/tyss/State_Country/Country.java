package edu.tyss.State_Country;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
	@Id
	private int id;
	private String name;
	private String language;
	
	public Country() {
	}

	public Country(int id, String name, String language) {
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

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", language=" + language + "]";
	}
	
	
	
}
