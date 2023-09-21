package com.nit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.model.Employee;
import com.nit.service.EmployeeMgmtServiceImpl;
import com.nit.service.IEmployeeMgmtService;


@WebServlet(urlPatterns="/controllerurl", loadOnStartup=1)
public class MainControllerServlet extends HttpServlet {
	  
	 IEmployeeMgmtService service;
	 
	 @Override
	public void init() throws ServletException {
		service = new EmployeeMgmtServiceImpl();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read form data
		String desg = req.getParameter("job");
		String action = req.getParameter("s1");
		
		try {
		//invoke b.method on service class object
		List<Employee> list = service.fetchEmpsDesg(desg);
		
		//keep the result in request scope to send to view comps
		req.setAttribute("empDetails", list);
		
		//forward the req to result page based on the button that is clicked
		   String resultpage = null;
		   
		   if(action.equalsIgnoreCase("HtmlOutput"))
		        resultpage="/html_screen.jsp";
		   else
			   resultpage="/excel_screen.jsp";
		   
		   //forward the request to result page
		   RequestDispatcher rd = req.getRequestDispatcher(resultpage);
		   rd.forward(req, res);
		   
		}//try
		catch (SQLException se) {
			se.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
	}
	

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
