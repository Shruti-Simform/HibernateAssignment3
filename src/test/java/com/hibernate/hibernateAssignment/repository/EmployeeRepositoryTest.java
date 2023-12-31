package com.hibernate.hibernateAssignment.repository;

import com.hibernate.hibernateAssignment.HibernateAssignmentApplication;
import com.hibernate.hibernateAssignment.entity.Address;
import com.hibernate.hibernateAssignment.entity.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = HibernateAssignmentApplication.class)
class EmployeeRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EmployeeRepository repository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmploymentTypeRepository employmentTypeRepository;
    @Test
    public void test10(){
        Employee employee = repository.findById(101).get();
        logger.info("Testing empId {}",employee.getEmpId());
        assertEquals(101,employee.getEmpId());
    }
    @Test
    public void test11(){
        Employee employee = repository.findById(101).get();
        logger.info("Testing empName {}",employee.getEmpName());
        assertEquals("Alex",employee.getEmpName());
    }
    @Test
    public void test12(){
        Employee employee = repository.findById(101).get();
        logger.info("Testing department {}",employee.getDepartment().getDeptName());
        assertEquals("HR",employee.getDepartment().getDeptName());
    }
    @Test
    public void test13(){
        Employee employee = repository.findById(101).get();
        logger.info("Testing city {}",employee.getAddress().getCity());
        assertEquals("Mumbai",employee.getAddress().getCity());
    }
    @Test
    @Transactional
    public void test14(){
        Employee employee = new Employee(103,"Ben",new Address("Street 1","Pune","MH"),departmentRepository.findById(202).get(),employmentTypeRepository.findById(2).get());
        repository.save(employee);
        logger.info("Employee name {}",repository.findById(103).get().getEmpName());
    }
}