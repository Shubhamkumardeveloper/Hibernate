package edu.tyss.caching;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestStudentSave {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("cache");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s1=new Student();
		s1.setName("Shubham kumar");
		s1.setEmail("s@gmail.com");
		
		Student s2=new Student();
		s2.setName("Shubham kumar");
		s2.setEmail("s@gmail.com");
		
		et.begin();
		em.persist(s1);
		em.persist(s2);
		et.commit();
		
	}

}
