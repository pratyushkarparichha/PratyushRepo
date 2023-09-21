package com.nit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.nit.model.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {
  private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO, ENAME, JOB, SAL, FROM EMP WHERE JOB=?";
	@Override
	public List<Employee> getEmpsByDesg(String desg) throws Exception {
		
		List<Employee> list = null;
		
		   //create jdbc driver class object
				oracle.jdbc.driver.OracleDriver obj = new oracle.jdbc.driver.OracleDriver();
				     // register JDBC driver class object with DriverManager service
				DriverManager.registerDriver(obj);
				
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS)) {
		  
			//Set Query param value
		   ps.setString(1,desg);
		   
		  //execute the query
		   try(ResultSet rs = ps.executeQuery()) {
			  
			   //convert rs object record list of employee object
			   list = new ArrayList<Employee>();
			   while(rs.next()) {
				   Employee e = new Employee();
				   e.setEno(rs.getInt(1));
				   e.setEname(rs.getString(2));
				   e.setDesg(rs.getString(3));
				   e.setSalary(rs.getFloat(4));
				   list.add(e);
			   }//while
		   }//try2
		}//try1
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}//method
	
	   //private are taken as helper methods.
 /*	private Connection getPooledConnection() throws Exception {
		InitialContext ic = new InitialContext();
		DataSource ds =(DataSource)ic.lookup("java:/comp/env/DsJndi");
		return ds.getConnection();
	}//method
 */	
	

}//class
