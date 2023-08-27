package edu.tyss.User_SocialMedia;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class UserController {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		User_ u=new User_(1,"shubham", "shubu@gmail.com");
		SocialMedia s1=new SocialMedia(101, "FACEBOOK", "www.fb.com");
		SocialMedia s2=new SocialMedia(102, "INSTAGRAM", "www.insatgram.com");
		SocialMedia s3=new SocialMedia(103, "snapchat", "www.snapchat.com");
		
		List<SocialMedia> socialMedias=Arrays.asList(s1,s2,s3);
		u.setSocialMedias(socialMedias);
		et.begin();
		em.persist(u);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();
	}
	
	public void find()
	{
		User_ u=em.find(User_.class, 1);
		if(u!=null)
		{
			System.out.println(u);
			List<SocialMedia> lMedias=u.getSocialMedias();
			for(SocialMedia s:lMedias)
				System.out.println(s);
		}
		else
			System.out.println("Record Not found");
	}
	
	public void update()
	{
		User_ u=em.find(User_.class, 1);
		if(u!=null)
		{
			List<SocialMedia> lMedias=u.getSocialMedias();
			for(SocialMedia s:lMedias)
			{
				if(s.getId()==101)
				{
					s.setName("twitter");
					s.setUrl("www.twitter.com");
					et.begin();
					em.merge(s);
					et.commit();
				}
			}
		}
		else
			System.out.println("Record Not found");
	}
	
	public void delete()
	{
		User_ u=em.find(User_.class, 1);
		if(u!=null)
		{
			List<SocialMedia> l=u.getSocialMedias();
			Iterator<SocialMedia> i=l.iterator();
			while(i.hasNext())
			{
				SocialMedia s=i.next();
				if(s.getId()==101)
				{
					i.remove();
					et.begin();
					em.remove(s);
					et.commit();
				}
			}
			
		}
		else
			System.out.println("Record Not found");
	}

}
