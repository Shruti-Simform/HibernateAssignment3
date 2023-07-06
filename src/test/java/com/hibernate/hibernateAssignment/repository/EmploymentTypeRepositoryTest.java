package com.hibernate.hibernateAssignment.repository;

import com.hibernate.hibernateAssignment.entity.EmploymentType;
import jakarta.servlet.http.Part;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmploymentTypeRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EmploymentTypeRepository repository;
    @Autowired
    FullTimeEmployeeRepository fullTimeEmployeeRepository;
    @Autowired
    PartTimeEmployeeRepository partTimeEmployeeRepository;

    @Test
    public void test30(){
        EmploymentType employmentType = repository.findById(1).get();
        logger.info("Testing employmentType {}",fullTimeEmployeeRepository.findById(1).get().getEmployeeTypePart());
        assertEquals("FullTimeEmployee",fullTimeEmployeeRepository.findById(1).get().getEmployeeTypePart());
    }
    @Test
    public void test31(){
        EmploymentType employmentType = repository.findById(2).get();
        logger.info("Testing employmentType {}",partTimeEmployeeRepository.findById(2).get().getEmployeeTypePart());
        assertEquals("PartTimeEmployee",partTimeEmployeeRepository.findById(2).get().getEmployeeTypePart());
    }
}