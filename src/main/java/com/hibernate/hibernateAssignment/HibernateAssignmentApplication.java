package com.hibernate.hibernateAssignment;

import com.hibernate.hibernateAssignment.entity.Address;
import com.hibernate.hibernateAssignment.entity.Employee;
import com.hibernate.hibernateAssignment.entity.FullTimeEmployee;
import com.hibernate.hibernateAssignment.entity.PartTimeEmployee;
import com.hibernate.hibernateAssignment.repository.DepartmentRepository;
import com.hibernate.hibernateAssignment.repository.EmployeeRepository;
import com.hibernate.hibernateAssignment.repository.EmploymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class
HibernateAssignmentApplication implements CommandLineRunner {

	@Autowired
	EmploymentTypeRepository employmentTypeRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	public static void main(String[] args) {
		SpringApplication.run(HibernateAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
          employmentTypeRepository.save(new FullTimeEmployee(2000,"9-5 PM"));
		  employmentTypeRepository.save(new PartTimeEmployee(100,"1-4 PM"));
		Address address = new Address("Street 202","Mumbai","Maharashtra");
		Employee employee = new Employee(101,"Alex",address,departmentRepository.findById(202).get(),employmentTypeRepository.findById(1).get());
		employeeRepository.save(employee);
	}
}
