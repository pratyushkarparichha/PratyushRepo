package com.nit.dao;

import java.util.List;

import com.nit.model.Employee;

public interface IEmployeeDAO {
   public List<Employee> getEmpsByDesg(String desg)throws Exception;
   
}
