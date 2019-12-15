package com.mycompany.example.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.example.model.Customer;

public class HibernateUtilFactory {

	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory()
	{
		factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
		return factory;
	}
}
