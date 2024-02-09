package com.nit.service;

import com.nit.bo.EmployeeBO;
import com.nit.dao.IEmployeeDAO;
import com.nit.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	//HAS-A Property
	private IEmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
		System.out.println("EmployeeMgmtServiceImpl:: 1-param with DAO class loading from cfgs");
		this.dao=dao;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		//write b.logic to calculate grosssalary and netsalary
		float grossSalary = dto.getBasicSalary()+ dto.getBasicSalary()*0.4f; //+40% on basicSalary
		float netSalary = grossSalary - dto.getBasicSalary()*0.2f; //-20% on grossSalary
		
		//prepare BO class obj having persistable data
		EmployeeBO bo = new EmployeeBO();
		bo.setEname(dto.getEname());
		bo.setDesg(dto.getDesg());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setGrossSalary(grossSalary);
		bo.setNetSalay(netSalary);
		
		//use dao
		int count=dao.insertEmployee(bo);
		//generate final result
		
		return count==1?"Employee registerd with netSalary:: "+netSalary:
			            "Employee not registered with netSalary:: "+netSalary;
	}

}
