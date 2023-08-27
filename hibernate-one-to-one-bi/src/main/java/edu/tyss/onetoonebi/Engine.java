package edu.tyss.onetoonebi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Engine {
	@Id
	private int id;
	private String type;
	private int cc;
	
	@OneToOne(mappedBy ="engine")
	private Car car;

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public int getCc() {
		return cc;
	}

	public Car getCar() {
		return car;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	

}
