package edu.tyss.Teacher_Subject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Teacher {
	@Id
	private int id;
	private String name;
	private String Email;
	
	@OneToOne
	private Subject subject;
	
	public Teacher() {
	}

	public Teacher(int id, String name, String email) {
		this.id = id;
		this.name = name;
		Email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return Email;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", Email=" + Email + ", subject=" + subject + "]";
	}
	
	

}
