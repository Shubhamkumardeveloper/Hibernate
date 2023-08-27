package edu.tyss.socialmediaApp_many_to_many_uni.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import socialmediaApp_many_to_many_uni.SocialMedia;
import socialmediaApp_many_to_many_uni.User_;

public class UserController {
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("socialmedia");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
        User_ u=new User_(101,"imshubu18","shubu@gmail.com");
		
		SocialMedia s1=new SocialMedia(1001,"Facebook","www.facebook.com");
		SocialMedia s2=new SocialMedia(1002,"Instagram","www.instagram.com");
		SocialMedia s3=new SocialMedia(1003,"snapchat","www.snapchat.com");
		
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
		User_ u=em.find(User_.class,101);
		if(u!=null)
		{
			List<SocialMedia> socialMedias=u.getSocialMedias();
			System.out.println("=========User Details:==========");
			System.out.println("User Id:"+u.getUser_id());
			System.out.println("username:"+u.getUsername());
			System.out.println("Email:"+u.getEmail());
			System.out.println("================================\n");
			
			for(SocialMedia s:socialMedias)
			{
				System.out.println("=========Social Media Details:==========");
				System.out.println("Social Media Id:"+s.getSocial_media_id());
				System.out.println("Social Media Name:"+s.getSocial_media_name());
				System.out.println("Social Media Url:"+s.getSocial_media_url());
				System.out.println("================================\n");
			}
		}
	}
	
	public void update(int u_id,int s_id,String newMediaName,String newUrl)
	{
		
		User_ u=em.find(User_.class,u_id);
		if(u!=null)
		{
			List<SocialMedia> socialMedias=u.getSocialMedias();
			for(SocialMedia s:socialMedias)
			{
				if(s.getSocial_media_id()==s_id)
				{
					s.setSocial_media_name(newMediaName);
					s.setSocial_media_url(newUrl);
					et.begin();
					em.merge(s);
					et.commit();
				}
			}
		}
	}
	
	public void delete(int u_id,int s_id)
	{
		User_ u=em.find(User_.class,u_id);
		if(u!=null)
		{
			List<SocialMedia> socialMedias=u.getSocialMedias();
			Iterator<SocialMedia> i=socialMedias.iterator();
			while(i.hasNext())
			{
				SocialMedia s=i.next();
				if(s.getSocial_media_id()==s_id)
				{
					i.remove();
					et.begin();
					em.remove(s);
					et.commit();
				}
			}
		}
	}
	
	

}
