package edu.tyss.Country_Capital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CountryController {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("onetoone");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et=em.getTransaction();
	 
	
	 
	 public static void main(String[] args) {
		System.out.println(emf);
	}

}
