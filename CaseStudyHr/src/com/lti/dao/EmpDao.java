package com.lti.dao;

import java.util.ArrayList;

import com.lti.bean.Employee;

public interface EmpDao {
	
	ArrayList<Employee> addEmployee(Employee e);
	ArrayList<Employee>getEmpList();
	

}
