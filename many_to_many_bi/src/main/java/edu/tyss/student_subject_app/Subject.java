package edu.tyss.student_subject_app;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	private int id;
	private String name;
	private int days;
	
	@ManyToMany(mappedBy ="subjects")
	private List<Student> students;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getDays() {
		return days;
	}

	public List<Student> getStudents() {
		return students;
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

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
