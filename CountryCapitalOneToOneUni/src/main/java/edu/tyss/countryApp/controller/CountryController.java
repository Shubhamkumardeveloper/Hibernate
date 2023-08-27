package edu.tyss.countryApp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.countryApp.model.Country;
import edu.tyss.countryApp.model.State;

public class CountryController {
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("country");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		State s=new State(1,"Dehli", 101);
		Country c=new Country(101,"India", s);
		et.begin();
		em.persist(c);
		em.persist(s);
		et.commit();
	}
	public static void main(String[] args) {
		
		
	}

}
