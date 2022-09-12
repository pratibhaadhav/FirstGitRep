package com.lti.user;

import com.lti.bean.Employee;
import com.lti.services.EmpService;
import com.lti.services.EmpServiceImpl;

public class UserApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    // Employee e1=new Employee(2,"pratibha",6000);
      
      EmpService service =new EmpServiceImpl();
      //int empId=service.addEmployee(e1);
      //System.out.println("You are registered with "+empId);
      
      service.getEmpList();
      
      
	}

}
