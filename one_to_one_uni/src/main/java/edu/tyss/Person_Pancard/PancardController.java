package edu.tyss.Person_Pancard;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PancardController {
	 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("onetoone");
	 private static EntityManager em = emf.createEntityManager();
	 private static EntityTransaction et=em.getTransaction();

	 public void save()
	 {
		 
			
			
	 }




}
