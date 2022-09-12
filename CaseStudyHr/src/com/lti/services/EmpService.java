package com.lti.services;

import java.util.ArrayList;

import com.lti.bean.Employee;

//menu card
public interface EmpService {

	ArrayList<Employee>addEmployee(Employee e);
	void getEmpList();
	
	
}
