package edu.tyss.manytomanyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFindRecords {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
		EntityManager em=emf.createEntityManager();
		
		Student s=em.find(Student.class,2);
		List<Subject> subjects=s.getSubjects();
		
		System.out.println("================Student Details:==========");
		System.out.println("Student id:"+s.getId());
		System.out.println("Student Name:"+s.getName());
		System.out.println("Student Email"+s.getEmail());
		System.out.println("============================================\n");
		for(Subject s1:subjects)
		{
			System.out.println("========Subject details:=============");
			System.out.println("Subject Id:"+s1.getId());
			System.out.println("Subject Name:"+s1.getName());
			System.out.println("Subejct Days:"+s1.getDays());
			System.out.println("============================================\n");
			
		}
	}

}
