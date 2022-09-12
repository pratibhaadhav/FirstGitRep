package com.lti.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Employee;

public class EmployeeApp2 {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

	public static void persistEmployees() {
		Employee e1 = Employee.createEmployee(205, "Priya", "Admin", 12000);
		Employee e2 = Employee.createEmployee(206, "pratibha", "Marketting", 2500);
		Employee e3 = Employee.createEmployee(207, "pooja", "Hr", 10000);
		Employee e4 = Employee.createEmployee(208, "Rutuja", "Support", 15000);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.getTransaction().commit();
		em.close();

	}

	public static void findEmpBySalaryRange() {
		System.out.println("employee List By Salary Range 11000 to 20000");
		EntityManager em = emf.createEntityManager();
		Query q1 = em.createNamedQuery(Employee.SALARY_RANGE_QUERY);
		q1.setParameter("min",11000L);
		q1.setParameter("max",20000L);
		
		List<Employee> elist = q1.getResultList();
		elist.forEach(System.out::println);
		em.close();

	}

	public static void main(String[] args) {
		try {
			persistEmployees();
			findEmpBySalaryRange();
			// findEmployee("Admin");
			// countNoEmployees();
			// MaxSalaryemployee();
			// MinSalaryemployee();
			// SalaryOrder();
			// ElistByTypedQuery() ;

		}

		finally {
			emf.close();
		}

	}

}
