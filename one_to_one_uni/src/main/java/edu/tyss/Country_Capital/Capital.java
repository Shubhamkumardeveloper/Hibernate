package edu.tyss.Country_Capital;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Capital {
	
	@Id
	private int id;
	private String name;
	
	public Capital() {
	}

	public Capital(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Capital [id=" + id + ", name=" + name + "]";
	}
	
}
