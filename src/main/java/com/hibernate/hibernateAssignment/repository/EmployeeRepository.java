package com.hibernate.hibernateAssignment.repository;

import com.hibernate.hibernateAssignment.entity.Employee;
import com.hibernate.hibernateAssignment.entity.PartTimeEmployee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
