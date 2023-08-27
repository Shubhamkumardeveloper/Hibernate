package edu.tyss.Book_Librabry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookController {
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytoone");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		Library l=new Library(101,"Bangalore centrel", "BTM layout");
		
		Book b1=new Book(1,"Half Girlfriend", "novel");
		b1.setLibrary(l);
		Book b2=new Book(2, "Physics vol 1", "Physics");
		b2.setLibrary(l);
		
		et.begin();
		em.persist(l);
		em.persist(b1);
		em.persist(b2);
		et.commit();
		
	}
	
	public void find()
	{
		Book b=em.find(Book.class,1);
		if(b!=null)
		{
			System.out.println(b);
		}
		else
			System.out.println("Book Not found");
	}
	
	public void update()
	{
		Book b=em.find(Book.class,1);
		if(b!=null)
		{
			b.setTitle("New Title..");
			et.begin();
			em.merge(b);
			et.commit();
		}
		else
			System.out.println("Book Not found");
	}
	
	public void delete()
	{
		Book b=em.find(Book.class,1);
		if(b!=null)
		{
			et.begin();
			em.remove(b);
			et.commit();
		}
		else
			System.out.println("Book Not found");
	}

}
