package edu.tyss.Student_Subject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	private int id;
	private String name;
	private int days;
	
	public Subject() {
	}
	
	
	
	public Subject(int id, String name, int days) {
		super();
		this.id = id;
		this.name = name;
		this.days = days;
	}



	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getDays() {
		return days;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDays(int days) {
		this.days = days;
	}



	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", days=" + days + "]";
	}
	
	

}
