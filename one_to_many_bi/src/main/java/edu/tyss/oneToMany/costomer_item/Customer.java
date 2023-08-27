package edu.tyss.oneToMany.costomer_item;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	private int id;
	private String name;
	private String address;
	
	@OneToMany(mappedBy = "customer")
	private List<Item> items;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

}
