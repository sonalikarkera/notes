package com.mycompany.example.view;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.example.dao.CustomerDao;
import com.mycompany.example.dao.CustomerDaoImpl;
import com.mycompany.example.model.Customer;

public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> l = null;

	private String type = null;
	private String[] typeArr;

	private CustomerDao dao=null;

	private List<Customer> list = null;
	
	private List<Customer> list1 = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		type = config.getInitParameter("type-list");
		typeArr = type.split(",");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		l = (List<String>) request.getAttribute("ERROR");
		if (l != null) {
			out.println("please correct the bellow error(s)<br/>");
			for (String str : l) {
				out.println("<font color='red'>" + str + "</font><br/>");
			}
		}

		out.println("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n"
				+ "<title>Insert title here</title>\n" + "</head>\n" + "<body>\n" + "<!-- Default form login -->\n"
				+ "<form class=\"text-center border border-light p-5\" action=\"AddCustomer.do\" method=\"post\">\n"
				+ "\n" + "    <p class=\"h4 mb-4\">Input League Details.</p>\n" + "\n" + "    \n"
				+ "    <input type=\"text\" id=\"defaultLoginFormEmail\" class=\"form-control mb-4\" placeholder=\"id\" name=\"id\">\n"
				+ "\n" + "    \n"
				+ "    <input type=\"text\" id=\"defaultLoginFormPassword\" class=\"form-control mb-4\" placeholder=\"name\" name=\"name\">\n"
				+ "\n");

		out.println("Type<select name='type'>");
		for (String str :typeArr) {

			out.println("<option value='" + str + "'>" + str + "</option>");
		}
		out.println("</select>");

		out.println("\n" + "    <!-- Sign in button -->\n"
				+ "    <button class=\"btn btn-info btn-block my-4\" type=\"submit\">Add A New League</button>\n" + "\n"
				+ "\n" + "</form>\n" + "\n" + "</body>\n" + "</html>");
		dao = new CustomerDaoImpl();
		list = dao.getAllCustomer();
	out.println("<div class='container'><table border class='table'><tr><td>Name</td><td>ID</td><td>Type</td></tr>");
	for(Customer l:list)
		{
			out.println("<tr><td>"+l.getName()+"</td><td>"+l.getId()+"</td><td>"+l.getType()+"</td></tr>");
		}
	
	
	
	
	
	
	out.println("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
			+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n"
			+ "<title>Insert title here</title>\n" + "</head>\n" + "<body>\n" + "<!-- Default form login -->\n"
			+ "<form class=\"text-center border border-light p-5\" action=\"AddCustomer.do\" method=\"post\">\n"
			);

	
	out.println("Id<select name='id'>");
	list1 = dao.getAllCustomer();
	for (Customer l:list1) {

		out.println("<option value='" + l.getId() + "'>" + l.getId() + "</option>");
	}
	out.println("</select>");
	out.println("\n" + "    <!-- Delete -->\n"
			+ "    <button class=\"btn btn-info btn-block my-4\" type=\"submit\">Add A New League</button>\n" + "\n"
			+ "\n" + "</form>\n" + "\n" + "</body>\n" + "</html>");
	
	
	
	
	
	
	
		out.println("</div></table><a href='index.html'>Go To Home Page</a></body></html>");
		
		out.println("\n" + "</body>\n" + "</html>");
	}

}