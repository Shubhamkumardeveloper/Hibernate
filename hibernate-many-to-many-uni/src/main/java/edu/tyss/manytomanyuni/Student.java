package edu.tyss.manytomanyuni;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	@ManyToMany
	private List<Subject> subjects;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
