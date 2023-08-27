package edu.tyss.firstLevelCache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentFound {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("cache");
		EntityManager em=emf.createEntityManager();
		
		Student s=em.find(Student.class,5);
		
		System.out.println(s);
		System.out.println("=====================================");
		EntityManager em1=emf.createEntityManager();
		Student s1=em1.find(Student.class,5);
		System.out.println(s1);
		System.out.println("============================================");
		EntityManager em2=emf.createEntityManager();
		Student s2=em2.find(Student.class,5);
		System.out.println(s2);
		
	}

}
