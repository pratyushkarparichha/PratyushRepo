package com.nit;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.controller.PayrollSystemController;
import com.nit.model.Employee;

@SpringBootApplication
public class SpringBootLayeredApplication {
	
	public static void main(String[] args) {
		//get IOC Container 
		ApplicationContext ctx = SpringApplication.run(SpringBootLayeredApplication.class, args);
		
		//get controller class object
        PayrollSystemController controller = ctx.getBean("controller", PayrollSystemController.class);
		
		//gather inputs from enduser
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Desg1::");
		String d1 = sc.next().toUpperCase();
		System.out.println("Enter Desg2::");
		String d2 = sc.next().toUpperCase();
		System.out.println("Enter Desg3::");
		String d3 = sc.next().toUpperCase();
		
		sc.close();
		
		try {
			List<Employee> listEmps = controller.showEmpsDetailsByDesgs(d1, d2, d3);
			for(Employee e:listEmps) {
				System.out.println(e);
			}//for
		}//try
		catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Internal DB Problem");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal Unknow Problem");
		}
	}
}
