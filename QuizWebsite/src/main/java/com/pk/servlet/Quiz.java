package com.pk.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Quiz extends HttpServlet {
   
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	   
		//get writer
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String name = req.getParameter("pname");
		
		//Wrinting b.logic 
		pw.println
		("<h1 style='color:green ; text-align:center'>Hey "+name+" "
				+ "Choose The Below Link To Select The Topic</h1>");
		
		//adding another hyperlink 
		pw.println("<a style='text-align:center' href='Topic.html'> TOPIC</a>");
		pw.println("<br><br>");
		pw.println("<a href='Home.html'> <img src='images/Home.png' width='50' hight='50'></a>");
		//close stream 
		pw.close();
		
		
	}
}
