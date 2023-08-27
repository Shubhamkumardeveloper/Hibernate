package edu.tyss.foodapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Food_app_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String role;
	
	@OneToOne(mappedBy = "user")
	@Cascade(CascadeType.ALL)
	private Menu menu;
	@Cascade(CascadeType.ALL)
	@OneToMany(mappedBy = "user")
	private List<Branch> branchs;
	@Cascade(CascadeType.ALL)
	@OneToMany(mappedBy = "user")
	private List<Food_Order> food_Orders;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public Menu getMenu() {
		return menu;
	}

	public List<Branch> getBranchs() {
		return branchs;
	}

	public List<Food_Order> getFood_Orders() {
		return food_Orders;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}

	public void setFood_Orders(List<Food_Order> food_Orders) {
		this.food_Orders = food_Orders;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", menu=" + menu + ", branchs=" + branchs + ", food_Orders=" + food_Orders + "]";
	}
	
	
}
