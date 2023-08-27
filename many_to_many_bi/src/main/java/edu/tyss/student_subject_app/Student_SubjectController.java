package edu.tyss.student_subject_app;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Student_SubjectController {
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomanybi");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		Student s2=new Student();
		s2.setId(2);
		s2.setName("sudhanshu kuamr");
		s2.setEmail("sh@gmail.com");
		
		Subject sub1=new Subject();
		sub1.setId(104);
		sub1.setName("DSA");
		sub1.setDays(90);
		
		Subject sub2=new Subject();
		sub2.setId(105);
		sub2.setName("COMPUTER NETWORK");
		sub2.setDays(50);
		
		Subject sub3=new Subject();
		sub3.setId(106);
		sub3.setName("CSS");
		sub3.setDays(35);
		Subject sub4=em.find(Subject.class, 101);
		List<Subject> subjects=Arrays.asList(sub1,sub2,sub3,sub4);
		
		Student s3=new Student();
		s3.setId(3);
		s3.setName("Anjesh kuamr");
		s3.setEmail("a@gmail.com");
		
		s2.setSubjects(subjects);
		s3.setSubjects(subjects);
		
		et.begin();
		em.persist(s2);
		em.persist(s3);
		em.persist(sub1);
		em.persist(sub2);
		em.persist(sub3);
		et.commit();
		
	}
	
	public void find()
	{
		Student s=em.find(Student.class,2);
		if(s!=null)
		{
			System.out.println("=======student=====");
			System.out.println("Id:"+s.getId());
			System.out.println("Name:"+s.getName());
			System.out.println("Email:"+s.getEmail());
			List<Subject> sList=s.getSubjects();
			for(Subject subject:sList)
			{
				System.out.println("========Subject=========");
				System.out.println("Id:"+subject.getId());
				System.out.println("name::"+subject.getName());
				System.out.println("Days::"+subject.getDays());
			}
		}
	}
	
	
	public void update()
	{
		Student s=em.find(Student.class,2);
		if(s!=null)
		{
			List<Subject> sList=s.getSubjects();
			for(Subject subject:sList)
			{
				if(subject.getId()==104)
				{
					subject.setDays(700);
					et.begin();
					em.merge(subject);
					et.commit();
				}
			}
		}
	}
	
	public void delete()
	{
		Student s=em.find(Student.class,3);
		et.begin();
		em.remove(s);
		et.commit();
//		if(s!=null)
//		{
//			List<Subject> sList=s.getSubjects();
//			Iterator<Subject> i=sList.iterator();
//			while(i.hasNext())
//			{
//				Subject s1=i.next();
//				if(s1.getId()==102)
//				{
//					i.remove();
//					et.begin();
//					em.remove(s1);
//					et.commit();
//				}
//			}
//					
//		}
	}
	
	

}
