package edu.tyss.carapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id
	private int carId;
	private String carName;
	private String carCompany;
	private String carNumber;
	private long carPrice;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public long getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(long carPrice) {
		this.carPrice = carPrice;
	}
//	@Override
//	public String toString() {
//		return "Car [carId=" + carId + ", carName=" + carName + ", carCompany=" + carCompany + ", carNumber="
//				+ carNumber + ", carPrice=" + carPrice + "]";
//	}
//	
	
}
