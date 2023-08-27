package edu.tyss.oneToMany.costomer_item;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	private int id;
	private String name;
	private double mrp;
	
	@ManyToOne
	@JoinColumn(name ="my_custmer_id")
	private Customer customer;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getMrp() {
		return mrp;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
