package edu.tyss.onetoonebi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("onetoonebi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Car c=new Car();
		c.setId(1);
		c.setName("SWIFT");
		c.setCost(20000);
		
		Engine e=new Engine();
		e.setId(101);
		e.setType("K2");
		e.setCc(1400);
		
		c.setEngine(e);
		e.setCar(c);
		et.begin();
		em.persist(c);
		em.persist(e);
		et.commit();
	}

}
