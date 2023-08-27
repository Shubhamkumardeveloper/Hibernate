package edu.tyss.foodapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Cascade(CascadeType.ALL)
	@OneToMany(mappedBy = "menu")
	private List<Food_Product> food_Products;
	
	@OneToOne
	@JoinColumn
	@Cascade(CascadeType.ALL)
	private User user;

	public int getId() {
		return id;
	}

	public List<Food_Product> getFood_Products() {
		return food_Products;
	}

	public User getUser() {
		return user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFood_Products(List<Food_Product> food_Products) {
		this.food_Products = food_Products;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
