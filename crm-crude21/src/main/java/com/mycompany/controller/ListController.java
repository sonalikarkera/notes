package com.mycompany.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;



import com.mycompany.dao.CustomerDao;
import com.mycompany.dao.CustomerDaoImpl;
import com.mycompany.model.Customer;


//when u hav multiple url use the below metod.. or else use single  name in ""
//@WebServlet(urlPatterns="/ListController")
@WebServlet("/ListController")


public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Customer> list;
	private CustomerDao dao;
	

	@Override
	public void init() throws ServletException {
		dao = new CustomerDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		list=dao.getAllCustomer();
		request.setAttribute("customers", list);
		RequestDispatcher view=request.getRequestDispatcher("list-customer.jsp");
		view.forward(request, response);
	}

}