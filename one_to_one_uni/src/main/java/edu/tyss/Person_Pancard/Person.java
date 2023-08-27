package edu.tyss.Person_Pancard;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int p_id;
	private String p_name;
	private String address;
	private long phoneNumber;
	private long pincode;
	@OneToOne
	private Pancard pancard;
	public int getP_id() {
		return p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public String getAddress() {
		return address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public long getPincode() {
		return pincode;
	}
	public Pancard getPancard() {
		return pancard;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}

}
