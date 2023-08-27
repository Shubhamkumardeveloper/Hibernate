package edu.tyss.foodapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int poductId;
	private String name;
	private String type;
	private int quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn
	@Cascade(CascadeType.ALL)
	private Food_Order food_Order;

	public int getId() {
		return id;
	}

	public int getPoductId() {
		return poductId;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public Food_Order getFood_Order() {
		return food_Order;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPoductId(int poductId) {
		this.poductId = poductId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setFood_Order(Food_Order food_Order) {
		this.food_Order = food_Order;
	}
}
