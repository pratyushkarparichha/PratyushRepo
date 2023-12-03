package com.pk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Maths extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	   
		//get writer
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		int count=0;
		String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
		a1=req.getParameter("1");
		a2=req.getParameter("2");
		a3=req.getParameter("3");
		a4=req.getParameter("4");
		a5=req.getParameter("5");
		a6=req.getParameter("6");
		a7=req.getParameter("7");
		a8=req.getParameter("8");
		a9=req.getParameter("9");
		a10=req.getParameter("10");
		
		if(a1.equals("b")) {
			count++;
		}else 
			pw.println("The correct anser for 1.Q is [b.  30, 48] <br>");
		
		if(a2.equals("c")) {
			count++;
		}else 
			pw.println("The correct anser for 2.Q is [c.  1200] <br>");
		
		if(a3.equals("b")) {
			count++;
		}else 
			pw.println("The correct anser for 3.Q is [b.  0] <br>");
		
		if(a4.equals("d")) {
			count++;
		}else 
			pw.println("The correct anser for 4.Q is [d.  11]  <br>");
		
		if(a5.equals("c")) {
			count++;
		}else 
			pw.println("The correct anser for 5.Q is [c.  1200]  <br>");
		
		if(a6.equals("d")) {
			count++;
		}else 
			pw.println("The correct anser for 6.Q is [d.  Non of these]  <br>");
		
		if(a7.equals("d")) {
			count++;
		}else 
			pw.println("The correct anser for 7.Q is [d.  10]  <br>");
		
		if(a8.equals("a")) {
			count++;
		}else 
			pw.println("The correct anser for 8.Q is [a.  14.02]  <br>");
		
		if(a9.equals("a")) {
			count++;
		}else 
			pw.println("The correct anser for 9.Q is [a.  15]  <br>");
		
		if(a10.equals("c")) {
			count++;
		}else 
			pw.println("The correct anser for 10.Q is [c.  480]  <br>");
		
		if(count==10) {
			pw.println(
			"<h1 style='color:green; text-align:center'> Congratulations you have answered all correct answers!</h1>");
		}else 
			pw.println("<h1 style='color:red; text-align:center'> You have scored " +count+"</h1>");
}
}
