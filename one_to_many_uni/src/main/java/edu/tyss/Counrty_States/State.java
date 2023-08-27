package edu.tyss.Counrty_States;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {
	private long id;
	private String name;
	@Id
	private String stateCode;
	private String stateLanguage;
	
	public State() {}



	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStateCode() {
		return stateCode;
	}

	public String getStateLanguage() {
		return stateLanguage;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public void setStateLanguage(String stateLanguage) {
		this.stateLanguage = stateLanguage;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", stateCode=" + stateCode + ", stateLanguage=" + stateLanguage
				+ "]";
	}

}
