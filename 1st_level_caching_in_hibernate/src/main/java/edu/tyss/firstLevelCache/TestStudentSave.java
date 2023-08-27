package edu.tyss.firstLevelCache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestStudentSave {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("cache");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s=new Student();
		s.setName("sudhanshu kumar");
		s.setEmail("s@gmail.com");
		
		
		
		et.begin();
		em.persist(s);
		et.commit();
		
	}

}
