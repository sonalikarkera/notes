package com.mycompany.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.example.model.Customer;

public class CustomersView extends HttpServlet {
	private static final long serialVersionUID = 1L;
private List<Customer> list=null;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list=new ArrayList<Customer>();
		list.add(new Customer(1,"Sonali","Normal"));
		list.add(new Customer(11,"Simnar", "Coorporate"));
		list.add(new Customer(22,"Anu", "Noraml"));
		out.println("<html><title>List All Available League</title><body><table border='1'><tr><td>Name</td><td>Id</td><td>Type</td></tr>");
		
		for(Customer l:list)
		{
			out.println("<tr><td>"+l.getName()+"</td><td>"+l.getId()+"</td><td>"+l.getType()+"</td></tr>");
		}
		out.println("</table><a href='index.html'>Go To Home Page</a></body></html>");
		
	}

	
}