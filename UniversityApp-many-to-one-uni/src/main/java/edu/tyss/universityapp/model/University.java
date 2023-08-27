package edu.tyss.universityapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University {
	@Id
	private int uid;
	private String name;
	private String universityRegNumber;
	
	public University() {
	}
	public University(int uid, String name, String universityRegNumber) {
		super();
		this.uid = uid;
		this.name = name;
		this.universityRegNumber = universityRegNumber;
	}
	public int getUid() {
		return uid;
	}
	public String getName() {
		return name;
	}
	public String getUniversityRegNumber() {
		return universityRegNumber;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUniversityRegNumber(String universityRegNumber) {
		this.universityRegNumber = universityRegNumber;
	}
	
	@Override
	public String toString() {
		return "\n\nUniversity id:"+uid+"\nUniversity Name:"+name+"\nUniversity Registration Number:"+universityRegNumber;
	}

}
