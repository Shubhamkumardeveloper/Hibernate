package edu.tyss.review.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUpdateRecords {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manyToOne");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Review r=em.find(Review.class,1);
		if(r!=null)
		{
			r.setMessage("Amazing product....");
			et.begin();
			em.merge(r);
			et.commit();
		}
		else
			System.out.println("Record not found...");
	}

}
