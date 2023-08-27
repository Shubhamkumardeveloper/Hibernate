package edu.tyss.manytomanyuni;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave1 {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s=new Student();
		s.setId(2);
		s.setName("Anil");
		s.setEmail("anil@gmail.com");
		
		Subject sb1=em.find(Subject.class,101);
		Subject sb2=em.find(Subject.class,102);
		
		Subject sb3=new Subject();
		sb3.setDays(50);
		sb3.setName("HTML");
		sb3.setId(301);
		
		List<Subject> subjects=Arrays.asList(sb1,sb2,sb3);
		s.setSubjects(subjects);
		et.begin();
		em.persist(s);
		em.persist(sb3);
		et.commit();
	}

}
