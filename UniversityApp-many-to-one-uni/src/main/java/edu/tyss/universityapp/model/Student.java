package edu.tyss.universityapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	private int sid;
	private String name;
	private String address;
	private String email;
	private long phoneNumber;
	
	@ManyToOne
	private University university;
	
	public Student() {
	}

	public Student(int sid, String name, String address, String email, long phoneNumber) {
		this.sid = sid;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getSid() {
		return sid;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public University getUniversity() {
		return university;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	
	@Override
	public String toString() {
		return "\nId:"+sid+"\nName:"+name+"\nAddress:"+address+"\nEmail:"+email+"\nphoneNumber:"+phoneNumber+"\nUniversity:"+university;
	}
}
