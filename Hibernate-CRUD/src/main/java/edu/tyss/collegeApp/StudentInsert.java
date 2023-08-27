package edu.tyss.collegeApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentInsert {
	public static void main(String[] args) {
		Student s=new Student();
		s.setRol(3);
		s.setName("Shikha");
		s.setEmail("shikha@gmail.com");
		s.setHeight(6);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shubu");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
		System.out.println("DATA INSETED");
	} 
}
