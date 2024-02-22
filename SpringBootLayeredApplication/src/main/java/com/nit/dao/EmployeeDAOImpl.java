package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DESGS = 
			                   "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN (?,?,?) ORDER BY JOB";
@Autowired	
 private DataSource ds;

	@Override
	public List<Employee> getEmpByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> listEmps = null;
		
		//get pooled jdbc con object 
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS)){ //try with resource
			//set query param values
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			listEmps = new ArrayList<Employee>();
			//execute query 
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSal(rs.getFloat(4));
					listEmps.add(emp);
				}
			}//try2
		}//try1
		catch (SQLException se) {
			se.printStackTrace();
			throw se; //exception rethrowing 
		} catch (Exception e) {
			e.printStackTrace();
			throw e; //exception rethrowing 
		}
	 return listEmps;	
	}
}
