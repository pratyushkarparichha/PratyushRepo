package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

public class JDBCConnection {
   
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
		
		     //closing con
		con.close();
		
	}
}
