package edu.tyss.fetchType_one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(nullable = false)
	private String name;
//	@Column(nullable = false,unique = true,updatable = false)
	private String email;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Pancard pancard;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Pancard getPancard() {
		return pancard;
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

	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", pancard=" + pancard + "]";
//	}

}
