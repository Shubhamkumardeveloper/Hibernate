package edu.tyss.Person_Ebook;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	@Id
	private int id;
	private String name;
	private String email;
	@ManyToMany
	private List<Ebook> ebooks;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public List<Ebook> getEbooks() {
		return ebooks;
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
	public void setEbooks(List<Ebook> ebooks) {
		this.ebooks = ebooks;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", ebooks=" + ebooks + "]";
	}
	
	

}
