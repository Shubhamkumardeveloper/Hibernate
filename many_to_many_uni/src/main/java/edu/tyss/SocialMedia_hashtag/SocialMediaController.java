package edu.tyss.SocialMedia_hashtag;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.User_SocialMedia.SocialMedia;
import edu.tyss.User_SocialMedia.User_;

public class SocialMediaController {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		SocialMedia_ s=new SocialMedia_(101,"fb", "www.fb.com");
		Hashtag h1=new Hashtag(1,"#wow");
		Hashtag h2=new Hashtag(2,"#cool");
		
		List<Hashtag> ht=Arrays.asList(h1,h2);
		s.setHashtags(ht);
		et.begin();
		em.persist(s);
		em.persist(h1);
		em.persist(h2);
		et.commit();
	}
	
	public void find()
	{
		SocialMedia_ s=em.find(SocialMedia_.class, 101);
		if(s!=null)
		{
			System.out.println(s);
			List<Hashtag> ht=s.getHashtags();
			for(Hashtag h:ht)
				System.out.println(h);
		}
		else
			System.out.println("Record Not Found..");
	}
	public void update()
	{
		SocialMedia_ s=em.find(SocialMedia_.class, 101);
		if(s!=null)
		{
			List<Hashtag> ht=s.getHashtags();
			for(Hashtag h:ht)
			{
				if(h.getId()==1)
				{
					h.setName("#yo");
					et.begin();
					em.merge(h);
					et.commit();
				}
			}
		}
		else
			System.out.println("Record Not found");
	}
	public void delete()
	{
		SocialMedia_ s=em.find(SocialMedia_.class, 101);
		if(s!=null)
		{
			List<Hashtag> ht=s.getHashtags();
			Iterator<Hashtag> i=ht.iterator();
			while(i.hasNext())
			{
				Hashtag hs=i.next();
				if(hs.getId()==2)
				{
					i.remove();
					et.begin();
					em.remove(hs);
					et.commit();
				}
			}
		}
		else
			System.out.println("Record Not found");
	}

}
