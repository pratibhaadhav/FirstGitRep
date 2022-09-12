package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = Employee.SALARY_RANGE_QUERY, query = "SELECT e FROM Employee e WHERE e.salary BETWEEN :min AND :max")
@Table(name = "Employee1")
public class Employee {

	public static final String SALARY_RANGE_QUERY = "salaryRangeQuery";
	@Id
	private int eid;
	private String ename;
	private String deptName;
	private long salary;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", deptName=" + deptName + ", salary=" + salary + "]";
	}

	public static Employee createEmployee(int eid, String ename, String deptName, long salary) {
		Employee empobj = new Employee();
		empobj.setEid(eid);
		empobj.setEname(ename);
		empobj.setDeptName(deptName);
		empobj.setSalary(salary);

		return empobj;

	}

}
