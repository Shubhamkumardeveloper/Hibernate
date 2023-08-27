package edu.tyss.Person_Ebook;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class PersonController {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		Person p=new Person(1, "shubu","s@gmail.com");
		Ebook e1=new Ebook(101, "shubham", "Harry Potter");
		Ebook e2=new Ebook(102, "anjesh", "IRon man");
		
		List< Ebook> e=Arrays.asList(e1,e2);
		p.setEbooks(e);
		et.begin();
		em.persist(p);
		em.persist(e1);
		em.persist(e2);
		et.commit();
		
	}
	
	public void find()
	{
		Person p=em.find(Person.class, 1);
		if(p!=null)
		{
			System.out.println(p);
			List<Ebook> e=p.getEbooks();
			for(Ebook e1:e)
				System.out.println(e1);
		}
		else
			System.out.println("Record Not found");
	}
	public void update()
	{
		Person p=em.find(Person.class, 1);
		if(p!=null)
		{
			System.out.println(p);
			List<Ebook> e=p.getEbooks();
			for(Ebook e1:e)
			{
				if(e1.getId()==101)
				{
					e1.setAuthor("ABC");
					et.begin();
					em.merge(e1);
					et.commit();
				}
			}
		}
		else
			System.out.println("Record Not found");
	}
	
	public void delete()
	{
		Person p=em.find(Person.class, 1);
		if(p!=null)
		{
			List<Ebook> e=p.getEbooks();
			Iterator< Ebook> i=e.iterator();
			while(i.hasNext())
			{
				Ebook s1=i.next();
				if(s1.getId()==101)
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
