package edu.tyss.Person_Passport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passport {
	@Id
	private int id;
	private String passportNumber;
	private String nationality;
	
	public int getId() {
		return id;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
