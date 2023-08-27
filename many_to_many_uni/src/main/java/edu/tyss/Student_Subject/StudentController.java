package edu.tyss.Student_Subject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentController {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		Student s=new Student(1,"Shubham kumar","s@gmail.com");
		
		Subject s1=new Subject(101, "JAVA", 90);
		Subject s2=new Subject(102, "HTML", 45);
		Subject s3=new Subject(103, "SQl", 55);
		
		List<Subject> subjects=Arrays.asList(s1,s2,s3);
		s.setSubjects(subjects);
		et.begin();
		em.persist(s);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();
	}
	
	public void find()
	{
		Student s=em.find(Student.class, 1);
		if(s!=null)
		{
			System.out.println(s);
			List<Subject> subjects=s.getSubjects();
			for(Subject s1:subjects)
				System.out.println(s1);
		}
		else
			System.out.println("Record Not Found");
	}
	public void update()
	{
		Student s=em.find(Student.class, 1);
		if(s!=null)
		{
			List<Subject> subjects=s.getSubjects();
			for(Subject s1:subjects)
			{
				if(s1.getId()==101)
				{
					s1.setDays(60);
					et.begin();
					em.persist(s1);
					et.commit();
				}
					
	
			}
		}
		else
			System.out.println("Record Not Found");
	}
	public void delete()
	{
		Student s=em.find(Student.class, 1);
		if(s!=null)
		{
			List<Subject> subjects=s.getSubjects();
			Iterator< Subject> i=subjects.iterator();
			while(i.hasNext())
			{
				Subject s1=i.next();
				if(s1.getId()==103)
				{
					i.remove();
					et.begin();
					em.remove(s1);
					et.commit();
				}
			}
		}
		else
			System.out.println("Record Not Found");
	}
	
}
