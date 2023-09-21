package com.nit.service;

import java.util.List;

import com.nit.dao.EmployeeDAOImpl;
import com.nit.dao.IEmployeeDAO;
import com.nit.model.Employee;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	private IEmployeeDAO empDAO;
	
	public EmployeeMgmtServiceImpl() {
		empDAO = new EmployeeDAOImpl();
	}

	@Override
	public List<Employee> fetchEmpsDesg(String desg) throws Exception {
		//use DAO
		List<Employee> list = empDAO.getEmpsByDesg(desg);
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.3f));
			emp.setGrossSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2f));
		                   });
		return list;
	}

}
