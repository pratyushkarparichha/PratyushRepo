package com.nit.dao;

import com.nit.model.Employee;
import java.util.List;

public interface IEmployeeDAO {
  
	public List<Employee> getEmpByDesgs (String desg1, String desg2, String desg3)throws Exception;
}
