package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class JDBC2 {
   
	public static void main(String[] args) throws Exception{
		
		     //create jdbc driver class object
		oracle.jdbc.driver.OracleDriver obj = new oracle.jdbc.driver.OracleDriver();
		     // register JDBC driver class object with DriverManager service
		DriverManager.registerDriver(obj);
		     // establish the connection 
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		
		if(con==null) {
			System.out.println("Connection is not Established");
		}
		else 
			System.out.println("Connection is Established");
		
		      //creating Statement
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT EMPNO, ENAME, JOB, SAL FROM EMP");
		
		while(rs.next()==true) {
			System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"     "+rs.getFloat(4));
		}
              // closing streams
		   rs.close();
		   st.close();
		   con.close();
	}
}
