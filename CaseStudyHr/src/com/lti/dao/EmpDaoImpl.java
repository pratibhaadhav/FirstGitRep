package com.lti.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lti.bean.Employee;

public class EmpDaoImpl implements EmpDao {

	Connection conn;
	ArrayList<Employee>empList=new ArrayList();
	
	public ArrayList<Employee> getEmpList() {
		System.out.println("Dao Layer");
		

		try {
		//create or establish connection
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sys as sysdba","1234");
		Statement stmt=conn.createStatement();	
		ResultSet rs=stmt.executeQuery("select * from empjdbc");
		
	while(rs.next())
	{
		       int eid=rs.getInt(1);
		 		String ename=rs.getString(2);
		       Double esal=rs.getDouble(3);
		       
		       //System.out.println(eid+" "+ename+" "+esal);
		       
		       Employee e=new Employee(eid,ename,esal);
		       
		       empList.add(e);
		       
	}
	System.out.println(empList);
		
		
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return empList;
		
		
		
		
	}
	
	
	
	public ArrayList<Employee> addEmployee(Employee e) {
		System.out.println(" In dao layer");
		
		//add it in database -jdbc
		
		//System.out.println("record added");
		
		//return e.getEmpId();
		
		try {
		//create or establish connection
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sys as sysdba","1234");
		PreparedStatement pstmt =conn.prepareStatement("insert into empjdbc values(?,?,?)");
		
		pstmt.setInt(1,e.getEmpId());
		pstmt.setString(2,e.getEmpName());
		pstmt.setDouble(3, e.getEmpSal());
		
		int rec=pstmt.executeUpdate();
		System.out.println(rec+ "Record Added");
		
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		//System.out.println("Connection Done!");
	
		
		return empList;
		
		
	}
	


	
	
}
