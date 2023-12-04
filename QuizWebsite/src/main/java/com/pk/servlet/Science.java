package com.pk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Science extends HttpServlet {
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException{
		
		//get writer
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//getting session attribute
		HttpSession s = req.getSession(false);
		String sn = (String)s.getAttribute("sname");
		
		//read form data
		int count = 0;
		String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
		a1 = req.getParameter("1");
		a2 = req.getParameter("2");
		a3 = req.getParameter("3");
		a4 = req.getParameter("4");
		a5 = req.getParameter("5");
		a6 = req.getParameter("6");
		a7 = req.getParameter("7");
		a8 = req.getParameter("8");
		a9 = req.getParameter("9");
		a10 = req.getParameter("10");
		
		//busness logic
		if(a1.equals("a")) {
			count++;
		}else
			pw.println("The correct anser for 1.Q is [a.  7.4] <br>");
		
		if(a2.equals("b")) {
			count++;
		}else
			pw.println("The correct anser for 2.Q is [b.  NaCI] <br>");
		
		if(a3.equals("a")) {
			count++;
		}else
			pw.println("The correct anser for 3.Q is [a.  Uranus] <br>");
		
		if(a4.equals("b")) {
			count++;
		}else
			pw.println("The correct anser for 4.Q is [b.  Calcium] <br>");
		
		if(a5.equals("d")) {
			count++;
		}else
			pw.println("The correct anser for 5.Q is [d.  Lithium] <br>");
		
		if(a6.equals("a")) {
			count++;
		}else
			pw.println("The correct anser for 6.Q is [a.  Washing Soda] <br>");
		
		if(a7.equals("d")) {
			count++;
		}else
			pw.println("The correct anser for 7.Q is [d.  methane, butane and propane] <br>");
		
		if(a8.equals("d")) {
			count++;
		}else
			pw.println("The correct anser for 8.Q is [d.  Mixture] <br>");
		
		if(a9.equals("a")) {
			count++;
		}else
			pw.println("The correct anser for 9.Q is [a.  Tungsten] <br>");
		
		if(a10.equals("a")) {
			count++;
		}else
			pw.println("The correct anser for 10.Q is [a.  Teflon] <br>");
		
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<h1 style='color:blue; text-align:center'> Hello "+sn+"</h1>");
		
		if(count==10) {
			pw.println(
			"<h1 style='color:green; text-align:center'> congratulations you have answered all questions correctly!</h1>");
		}else 
			pw.println("<h1 style='color:red; text-align:center'> You have scored " +count+"</h1>");
		
		pw.println("<br>");
		pw.println("<h4 style='color:green ; text-align:center'> <a href='Topic.html'> TOPIC </a> </h4>");
		pw.println("<br>");
		pw.println("<h1 style='color:green ; text-align:center'> <a href='Home.html'> <img src='images/Home.png' width='50' hight='50'> </a> </h1>");
	}
	
	
}
