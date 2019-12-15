package com.mycompany.example.dao;

import java.util.List;

import com.mycompany.example.model.Customer;

public interface CustomerDao {
	public void createCustomer(Customer customer);
	public List<Customer> getAllCustomer();
}