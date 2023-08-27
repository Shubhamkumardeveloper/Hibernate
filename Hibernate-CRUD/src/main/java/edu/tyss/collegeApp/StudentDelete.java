package edu.tyss.collegeApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDelete {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shubu");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s=em.find(Student.class,3);
		if(s!=null)
		{
			et.begin();
			em.remove(s);
			et.commit();
			System.out.println("RECORD DELETED....");
		}
		else
			System.out.println("RECORD NOT FOUND");
}
}