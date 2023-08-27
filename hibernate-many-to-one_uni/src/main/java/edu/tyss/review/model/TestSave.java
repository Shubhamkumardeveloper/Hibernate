package edu.tyss.review.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manyToOne");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Product p=new Product();
		p.setId(101);
		p.setName("Shoes");
		p.setCost(2000);
		
		Product p1=new Product();
		p1.setId(102);
		p1.setName("Bat");
		p1.setCost(1000);
		
		Review r1=new Review();
		r1.setId(1);
		r1.setHeading("Good one...");
		r1.setMessage("this is good...");
		r1.setProduct(p);
		
		Review r2=new Review();
		r2.setId(2);
		r2.setHeading("best one...");
		r2.setMessage("this was good...");
		r2.setProduct(p);
		
		Review r3=new Review();
		r3.setId(3);
		r3.setHeading("best one...");
		r3.setMessage("this was good...");
		r3.setProduct(p1);
		et.begin();
		em.persist(p);
		em.persist(p1);
		em.persist(r1);
		em.persist(r2);
		em.persist(r3);
		et.commit();
	}

}
