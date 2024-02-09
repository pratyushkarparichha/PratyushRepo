package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nit.bo.EmployeeBO;

public class EmployeeOracleDAOImpl implements IEmployeeDAO {
	private static final String EMP_INSERT_QUERY=
			                    "INSERT INTO REALTIMEDI_SPRING_EMPLOYEE VALUES(SP_ENO_SEQ.NEXTVAL,?,?,?,?,?)";
   //HAS-A Property
	private DataSource ds;
	
	public EmployeeOracleDAOImpl(DataSource ds) {
		System.out.println("EmployeeOracleDAOImpl:: 1-param with DataSource loading from cfgs");
	this.ds = ds;
	}

	@Override
	public int insertEmployee(EmployeeBO bo) throws Exception {
		int result;
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(EMP_INSERT_QUERY);)
		{//set values to query parameter
			ps.setString(1, bo.getEname());
			ps.setString(2, bo.getDesg());
			ps.setFloat(3, bo.getBasicSalary());
			ps.setFloat(4, bo.getGrossSalary());
			ps.setFloat(5, bo.getNetSalay());
			//execute the query
		    result=ps.executeUpdate();
		}//try
		catch (SQLException se) {
			se.printStackTrace();
			throw se; //exception rethrowing
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
//	@Override
//	public int insertEmployee(EmployeeBO bo) throws Exception {
//		Connection con = null;
//		PreparedStatement ps = null;
//		int result =0;
//		try {
//			//get pooled JDBC con object
//			con=ds.getConnection();
//			//create prepared statement object having query as the pre-compiled sql query
//			ps=con.prepareStatement(EMP_INSERT_QUERY);
		    //set values to query parameter
//			ps.setString(1, bo.getEname());
//			ps.setString(2, bo.getDesg());
//			ps.setFloat(3, bo.getBasicSalary());
//			ps.setFloat(4, bo.getGrossSalary());
//			ps.setFloat(5, bo.getNetSalay());
//			//execute the query
//			result=ps.executeUpdate();
//		}catch(SQLException se) {
//			se.printStackTrace();
//			throw se; //exception rethrowing 
//		}catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			try {
//				if (ps!=null)
//					ps.close();
//			}catch (SQLException se) {
//				se.printStackTrace();
//			}try {
//				if (con!=null)
//					con.close();
//			}catch (SQLException se) {
//				se.printStackTrace();
//			}
//		return result;
//   }
}
