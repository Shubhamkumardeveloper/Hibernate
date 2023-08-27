package edu.tyss.manytomanyuni;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s=new Student();
		s.setId(1);
		s.setName("Raju");
		s.setEmail("Raju@gmail.com");
		
		Subject sb1=new Subject();
		sb1.setId(101);
		sb1.setName("JAVA");
		sb1.setDays(90);
		
		Subject sb2=new Subject();
		sb2.setId(102);
		sb2.setName("SQL");
		sb2.setDays(45);
		
		List<Subject> subjects=Arrays.asList(sb1,sb2);
		s.setSubjects(subjects);
		et.begin();
		em.persist(s);
		em.persist(sb1);
		em.persist(sb2);
		et.commit();
		
		}
}
