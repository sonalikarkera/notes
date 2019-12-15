package com.mycompany.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import com.mycompany.example.factory.HibernateUtilFactory;
import com.mycompany.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	private Session session = null;
	private SessionFactory factory = null;

	{
		factory = HibernateUtilFactory.getSessionFactory();
	}

	public void createCustomer(Customer customer) {
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.persist(customer);
			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
	List<Customer> list=null;
		try {
			session=factory.openSession();
			session.getTransaction().begin();
			list=session.createQuery("from Customer").getResultList();
		} finally {
			session.close();
		}
		
		return list;
	}

}