package edu.tyss.manytomanyuni;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	private int id;
	private String name;
	private int days;
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
}
