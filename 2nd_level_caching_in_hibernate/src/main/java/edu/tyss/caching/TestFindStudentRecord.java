package edu.tyss.caching;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFindStudentRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("cache");
		EntityManager em1=emf.createEntityManager();
		
		Student s1=em1.find(Student.class,2);
		System.out.println(s1);
		
		System.out.println("===================================================");
		EntityManager em2=emf.createEntityManager();
		Student s2=em2.find(Student.class,2);
		System.out.println(s2);
		System.out.println("===================================================");
		
	}

}
