package edu.tyss.collegeApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentFetch {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shubu");
		EntityManager em=emf.createEntityManager();
		Student s=em.find(Student.class,1);
		if(s!=null)
		{
			System.out.println("===============================");
			System.out.println("Roll:"+s.getRol());
			System.out.println("Name:"+s.getName());
			System.out.println("Email:"+s.getEmail());
			System.out.println("Height:"+s.getHeight());
			System.out.println("===============================");
		}
		else
			System.out.println("Record Not found");
	}

}
