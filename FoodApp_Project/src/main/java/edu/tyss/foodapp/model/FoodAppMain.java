package edu.tyss.foodapp.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FoodAppMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("food");
		System.out.println(emf);
	}
}
