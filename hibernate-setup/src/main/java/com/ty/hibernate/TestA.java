package com.ty.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestA {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		System.out.println(entityManagerFactory);
	}
}
