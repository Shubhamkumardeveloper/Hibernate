package edu.tyss.fetchType_one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDao {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("fetch");
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		Student s1=null;
		System.out.println("hi");
		s1=em.find(Student.class,2);
		System.out.println(em.find(Student.class,2));
		System.out.println("hi");

		
		transaction.begin();
		
		System.out.println("Student Id : "+ s1.getId());
		System.out.println("Student Name : "+ s1.getName());
		System.out.println("Student Email : "+ s1.getEmail());
		s1.setName("Abcd");
		
		em.merge(s1);
		transaction.commit();
		
		System.out.println("Updated...");
		
		
//		if(s1!=null)
//		{
//			s1.setName("ANJESH");
//			em.merge(s1);
//		}
//		else {
//			System.out.println("Invalid Id");
//		}
			
		
	}

}
