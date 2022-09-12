package com.lti.services;

import java.util.ArrayList;

import com.lti.bean.Employee;
import com.lti.dao.EmpDao;
import com.lti.dao.EmpDaoImpl;

public  class EmpServiceImpl implements EmpService {
 EmpDao dao=new EmpDaoImpl();
	public ArrayList<Employee > addEmployee(Employee e) {
		
		 System.out.println("in service layer"+ e);
		 
		return dao.addEmployee(e);
	}
	
	public void getEmpList() {
		// TODO Auto-generated method stub
		System.out.println("Service Layer");
		
		dao.getEmpList();
	}
	
	}


