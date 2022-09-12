package com.lti.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.entity.Employee;

public class EmployeeApp {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

	public static void persistEmployees() {
		Employee e1 = Employee.createEmployee(205, "Priya", "Admin", 12000);
		Employee e2 = Employee.createEmployee(206, "Priya", "Marketting", 12000);
		Employee e3 = Employee.createEmployee(207, "Priya", "Hr", 10000);
		Employee e4 = Employee.createEmployee(208, "Priya", "Support", 12000);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.getTransaction().commit();
		em.close();

	}

	public static void findEmployee(String dept) {

		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT emp FROM Employee emp WHERE emp.deptName=:dep");
		query.setParameter("dep", dept);

		List<Employee> resultList = query.getResultList();
		resultList.forEach(System.out::println);
		em.close();
	}

	public static void countNoEmployees() {
		System.out.println("-----Total no. of Employees------");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT COUNT(e) FROM Employee e");

		long count = (long) query.getSingleResult();

		System.out.println("Count: " + count);
		em.close();
	}

	public static void MaxSalaryemployee() {
		System.out.println("-----Max Salary------");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT MAX(e.salary) FROM Employee e");
		long sal = (long) query.getSingleResult();

		System.out.println(sal);
		em.close();

	}

	public static void MinSalaryemployee() {
		System.out.println("-----Min Salary------");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT MIN(e.salary) FROM Employee e");
		long sal = (long) query.getSingleResult();

		System.out.println(sal);
		em.close();

	}

	public static void SalaryOrder() {
		System.out.println("------Salary------");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT e FROM Employee e ORDER BY e.salary");
		List<Employee> elist = query.getResultList();
		elist.forEach(System.out::println);
		em.close();

	}

	
	//TypeQuery
	public static void ElistByTypedQuery() {
		System.out.println("-----Employee List Using Typed Query -----");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e", Employee.class);
		List<Employee> elist = tq.getResultList();
		elist.forEach(System.out::println);
		em.close();
	}

	public static void main(String[] args) {
		try {
			persistEmployees();
			// findEmployee("Admin");
			//countNoEmployees();
			//MaxSalaryemployee();
			//MinSalaryemployee();
			//SalaryOrder();
			ElistByTypedQuery() ;

		}

		finally {
			emf.close();
		}

	}

}
