package edu.tyss.vehicle_person;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	private int id;
	private String name;
	private String number;
	
	@ManyToOne
	private Person person;
	
	public Vehicle() {
	}

	public Vehicle(int id, String name, String number, Person person) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public Person getPerson() {
		return person;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", number=" + number + ", person=" + person + "]";
	}
	
	
	
	

}
