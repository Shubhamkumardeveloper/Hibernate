package edu.tyss.foodapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Food_Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
	private double totalPrice;
	@CreationTimestamp
	private LocalDateTime orderCreatedTime;
	@UpdateTimestamp
	private LocalDateTime orderDeliverTime;
	private String customerName;
	private long contactNumber;
	
	@ManyToOne
	@JoinColumn
	@Cascade(CascadeType.ALL)
	private User user;

	public int getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public LocalDateTime getOrderCreatedTime() {
		return orderCreatedTime;
	}

	public LocalDateTime getOrderDeliverTime() {
		return orderDeliverTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public User getUser() {
		return user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setOrderCreatedTime(LocalDateTime orderCreatedTime) {
		this.orderCreatedTime = orderCreatedTime;
	}

	public void setOrderDeliverTime(LocalDateTime orderDeliverTime) {
		this.orderDeliverTime = orderDeliverTime;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
