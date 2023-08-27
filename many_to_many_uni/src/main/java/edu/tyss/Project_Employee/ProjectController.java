package edu.tyss.Project_Employee;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProjectController {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		Project p=new Project(101, "WEB DEV", "ON progress",3);
		Employee e1=new Employee(1,"Shubham", "S@gmail.com");
		Employee e2=new Employee(2,"Anjesh", "a@gmail.com");
		Employee e3=new Employee(3,"shubu", "Sh@gmail.com");
		
		List<Employee> employees=Arrays.asList(e1,e2,e3);
		
		p.setEmployees(employees);
		et.begin();
		em.persist(p);
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		et.commit();
	}
	public void find()
	{
		Project p=em.find(Project.class, 101);
		if(p!=null)
		{
			System.out.println(p);
			List<Employee> employees=p.getEmployees();
			for(Employee e:employees)
				System.out.println(e);
		}
		else
			System.out.println("Record not found..");
	}
	public void update()
	{
		Project p=em.find(Project.class, 101);
		if(p!=null)
		{
			List<Employee> employees=p.getEmployees();
			for(Employee e:employees)
			{
				if(e.getId()==1)
				{
					e.setEmail("shubuham@gmail.com");
					et.begin();
					em.merge(e);
					et.commit();
				}
			}
		}
		else
			System.out.println("Record not found..");
	}
	public void delete()
	{
		Project p=em.find(Project.class, 101);
		if(p!=null)
		{
			List<Employee> employees=p.getEmployees();
			Iterator<Employee> i=employees.iterator();
			while(i.hasNext())
			{
				Employee e=i.next();
				if(e.getId()==1)
				{
					i.remove();
					et.begin();
					em.remove(e);
					et.commit();
				}
			}
		}
		else
			System.out.println("Record not found..");
	}
	

}
