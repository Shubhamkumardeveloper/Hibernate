package edu.tyss.collegeApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentUpdate {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shubu");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s=em.find(Student.class,10);
		if(s!=null)
		{
			et.begin();
			s.setHeight(10);
			em.merge(s);
			et.commit();
			System.out.println("Record Updated");
		}
		else
			System.out.println("Record Not found");
	}

}
