package com.nit.controller;

import com.nit.dto.EmployeeDTO;
import com.nit.service.IEmployeeMgmtService;
import com.nit.vo.EmployeeVO;

public class MainController {
  
	//HAS-A Property
	private IEmployeeMgmtService service;
	
	public MainController(IEmployeeMgmtService service) {
		System.out.println("MainController:: 1=param with service classloading from cfgs");
		this.service = service;
	}
	
	public String processEmployee(EmployeeVO vo)throws Exception {
		//convert EmployeeVO class object to EmployeeDTO class object
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEname(vo.getEname());
		dto.setDesg(vo.getDesg());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		
		//use service
		String result = service.registerEmployee(dto);
		
		return result;
	}
}
