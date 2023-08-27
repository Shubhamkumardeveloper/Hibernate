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
public class Food_Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private String about;
	private String availability;
	private double price;
	
	@ManyToOne
	@JoinColumn
	@Cascade(CascadeType.ALL)
	private Menu menu;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getAbout() {
		return about;
	}

	public String getAvailability() {
		return availability;
	}

	public double getPrice() {
		return price;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Food_Product [id=" + id + ", name=" + name + ", type=" + type + ", about=" + about + ", availability="
				+ availability + ", price=" + price + ", menu=" + menu + "]";
	}
	
	
}
