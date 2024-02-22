package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.EmployeeDAOImpl;
import com.nit.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private EmployeeDAOImpl dao;
	

	@Override
	public List<Employee> fetchEmpDetailsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> listEmps = dao.getEmpByDesgs(desg1, desg2, desg3);
		return listEmps;
	}

}
