package edu.tyss.caching;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAllStudentRecords {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("cache");
		EntityManager em=emf.createEntityManager();
		
		Query query= em.createQuery("select s from Student s");
		List<Student> sList= query.getResultList();
		for(Student s:sList)
			System.out.println(s);
	}
}
