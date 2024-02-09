package com.nit.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.controller.MainController;
import com.nit.vo.EmployeeVO;

public class RealtimeDITest {
  
	public static void main(String[] args) {
		//create ioc container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reder = new XmlBeanDefinitionReader(factory);
	    reder.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");
	    
	    //get SpringBean class obj ref
	    MainController con = factory.getBean("controller",MainController.class);
	    
	    //read inputs as string value and store them into EmployeeVO class object
	    Scanner scn = new Scanner(System.in);
	    
	    System.out.println("Enter Employee Name:: ");
	    String name = scn.next();
	    
	    System.out.println("Enter Employee Desg:: ");
	    String desg = scn.next();
	    
	    System.out.println("Enter Employee basicSalary:: ");
	    String basicSalary = scn.next();
	    
	    //create EmployeeVO object
	    EmployeeVO vo = new EmployeeVO();
	    vo.setEname(name);
	    vo.setDesg(desg);
	    vo.setBasicSalary(basicSalary);
	    
	    //invoke method
	    try {
	    	String result = con.processEmployee(vo);
	    	System.out.println(result);
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
