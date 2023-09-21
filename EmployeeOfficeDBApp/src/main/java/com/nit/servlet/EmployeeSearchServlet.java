package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {
	private static final String GET_EMP_BY_ENO = "SELECT EMPNO, ENAME, SAL, JOB, FROM EMP WHERE EMPNP=?";
	
@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get print writer
   PrintWriter pw = res.getWriter();
   //set content type
   res.setContentType("text/html");
   //read form data
   int no = Integer.parseInt(req.getParameter("eno"));
   
  /* try {
	   Class.forName("oracle.jdbc.driver.OracleDriver");
   }
   catch (ClassNotFoundException cnf) {
	   cnf.printStackTrace();
   } */
   
   //create jdbc driver class object
 	try {	oracle.jdbc.driver.OracleDriver obj = new oracle.jdbc.driver.OracleDriver();
 		     // register JDBC driver class object with DriverManager service
 		DriverManager.registerDriver(obj);
 	}
 	catch (Exception e) {
 		e.printStackTrace();
 	}
 	
   //write jdbc code
   try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		   PreparedStatement ps = con.prepareStatement(GET_EMP_BY_ENO)){
		   if(ps!=null)
		       ps.setInt(1, no);
   try(ResultSet rs = ps.executeQuery()) {
	       if(rs!=null) {
	    	   if(rs.next()) {
	    		   pw.println("<h1 style='color:blue; text-align:center'> Employee Details are </h1>");
	    		   pw.println("<b> Employee Number::  "+rs.getInt(1)+"</b><br>");
	    		   pw.println("<b> Employee Name::    "+rs.getString(2)+"</b><br>");
	    		   pw.println("<b> Employee Salary::  "+rs.getFloat(3)+"</b><br>");
	    		   pw.println("<b> Employee Job::     "+rs.getString(4)+"</b><br>");
	    	   }//if
	    	   else {
	    		   pw.println("<h1 style='color:red; text-align:center'> Employee Details Not Found </h1>");
	    	   }//else
	       }//if
   }//try2
   }//try1
   catch (SQLException se) {
	se.printStackTrace();
   }
}
 
@Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 doGet(req,res);
}

}//class
