package com.mycompany.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.example.dao.CustomerDaoImpl;
import com.mycompany.example.model.Customer;

public class CustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String type;
	private String name;
	private int id;
	private List<String> errors;

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
		errors = new ArrayList<String>();
		String idd = request.getParameter("id");
		try {
			id=Integer.parseInt(idd);
		} catch (Exception e) {
			// TODO: handle exception
			errors.add("id field must be numeric");
		}
		name=request.getParameter("name");
		if(name.length()<=8)
		{
			errors.add("invalid name");
		}
		type=request.getParameter("type");
		if(type.equals("Unknown"))
		{
			errors.add("select a ");
		}
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("AddCustomer.view");
			view.forward(request, response);
		}
		else
		{
			Customer l = new Customer(name, type);
			request.setAttribute("SUCCESS", l);
			CustomerDaoImpl dao = new CustomerDaoImpl();
			dao.createCustomer(l);
			RequestDispatcher view = request.getRequestDispatcher("AddCustomer.view");
			view.forward(request, response);
		}

	}

}
