package com.ty.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
	//public no abstract class
	
	//public default constructor..
	
	@Id
	private int id;//primary key
	private String name;
	private String email;
	private long phone_no;
	private String subject;
	private double salary;
	private String degisnation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDegisnation() {
		return degisnation;
	}
	public void setDegisnation(String degisnation) {
		this.degisnation = degisnation;
	}
}
