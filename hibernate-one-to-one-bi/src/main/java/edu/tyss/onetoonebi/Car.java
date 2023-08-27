package edu.tyss.onetoonebi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Car {
	@Id
	private int id;
	private String name;
	private int cost;
	
	@OneToOne
	@JoinColumn(name = "my_engine_id")
	private Engine engine;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}
