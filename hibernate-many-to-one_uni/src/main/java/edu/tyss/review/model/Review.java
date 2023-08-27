package edu.tyss.review.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Review {
	@Id
	private int id;
	private String heading;
	private String message;
	@ManyToOne
	private Product product;
	public int getId() {
		return id;
	}
	public String getHeading() {
		return heading;
	}
	public String getMessage() {
		return message;
	}
	public Product getProduct() {
		return product;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
