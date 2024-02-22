package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.Employee;
import com.nit.service.EmployeeMgmtServiceImpl;

@Controller("controller")
public class PayrollSystemController {

	@Autowired
	private EmployeeMgmtServiceImpl service;
	
	public List<Employee> showEmpsDetailsByDesgs (String desg1, String desg2, String desg3)throws Exception{
		List<Employee> listEmps= service.fetchEmpDetailsByDesgs(desg1, desg2, desg3);
		return listEmps;
	}
}
