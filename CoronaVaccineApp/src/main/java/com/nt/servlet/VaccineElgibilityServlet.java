package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineElgibilityServlet extends HttpServlet {

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   
		//get writer
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String name = req.getParameter("pname");
		String addrs = req.getParameter("padd");
		int age = Integer.parseInt(req.getParameter("page"));
		
		//Wrinting b.logic 
		if(age<18) {
			pw.println
			("<h1 style='color:red; text-align:center'> Mr/Miss/Mirss."+name+"You are not elgible for corona vaccine </h1>");
		}
		else {
			pw.println
			("<h1 style='color:green; text-align:center'> Mr/Miss/Mirss."+name+"You are elgible for corona vaccine make it happen</h1>");
		}
		//add home hyperlink
		
		pw.println("<a href='corona_vaccine.html'> <img src='images/Home.png'></a>");
		//close stream 
		pw.close();
	}
	
	
}	
	