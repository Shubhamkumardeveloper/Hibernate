package edu.tyss.universityapp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.universityapp.model.Student;
import edu.tyss.universityapp.model.University;
import edu.tyss.universityapp.view.UniversityView;

public class UniversityController {
	private Scanner read=new Scanner(System.in);
	UniversityView uView=new UniversityView();
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("university");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		University u=uView.enterUniversityData(read);
		Student s1=uView.enterStudentData(read);
		s1.setUniversity(u);
		Student s2=uView.enterStudentData(read);
		s2.setUniversity(u);
//		Student s3=uView.enterStudentData(read);
//		s3.setUniversity(u);
		
		et.begin();
		em.persist(u);
		em.persist(s1);
		em.persist(s2);
		et.commit();
	}
	
	public Student find(int sid)
	{
		return em.find(Student.class,sid);
	}
	
	public boolean update(int sid,String newEmail)
	{
		Student s=em.find(Student.class,sid);
		if(s!=null)
		{
			s.setEmail(newEmail);
			et.begin();
			em.merge(s);
			et.commit();
			return true;
		}
		return false;
	}
	
	public boolean delete(int sid)
	{
		Student s=em.find(Student.class,sid);
		if(s!=null)
		{
			et.begin();
			em.remove(s);
			et.commit();
			return true;
		}
		return false;
		
	}
	

}
