package com.hibernate.hibernateAssignment.repository;

import com.hibernate.hibernateAssignment.entity.Department;
import com.hibernate.hibernateAssignment.entity.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    DepartmentRepository repository;
    @Test
    public void test20(){
        Department department = repository.findById(201).get();
        logger.info("Testing deptId {}",department.getDeptId());
        assertEquals("IT",department.getDeptName());
    }
    @Test
    public void test21(){
        Department department = repository.findById(202).get();
        logger.info("Testing deptId {}",department.getDeptId());
        assertEquals("HR",department.getDeptName());
    }
    @Test
    @Transactional
    public void test22(){
        Department department = new Department(211,"Support",new ArrayList<Employee>());
        repository.save(department);
        logger.info("Department {}",department);
    }
}