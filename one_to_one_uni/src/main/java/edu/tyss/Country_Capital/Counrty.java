package edu.tyss.Country_Capital;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Counrty {
	@Id
	private int id;
	private String name;
	@OneToOne
	private Capital capital;
	
	public Counrty() {
	}

	public Counrty(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Counrty [id=" + id + ", name=" + name + ", capital=" + capital + "]";
	}
}
