package edu.tyss.socialmediaApp_many_to_many_uni.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import socialmediaApp_many_to_many_uni.SocialMedia;

public class UserView {
	
	
	public static void main(String[] args) {
		
		UserController uController=new UserController();
		
//		uController.save();
//		uController.find();
//		uController.update(101, 1003, "x", "x.com");
		uController.delete(101,1003);
		
		
		
		
		
		
	}

}
