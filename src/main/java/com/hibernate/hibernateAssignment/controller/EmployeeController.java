package com.hibernate.hibernateAssignment.controller;

import com.hibernate.hibernateAssignment.entity.Employee;
import com.hibernate.hibernateAssignment.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/get")
    public List<Employee> findAll(){
        logger.info("Retrieving all employees");
        return employeeService.findAllEmployee();
    }

    @GetMapping("/get/{empId}")
    public Employee findById(@PathVariable Integer empId){
        logger.info("Retrieving empId {}",empId);
        return employeeService.findEmployeeById(empId);
    }

    @PostMapping("/add")
    public String insertEmployee(@RequestBody Employee employee){
        if (employee.getEmpId()!=null){
            logger.info("Inserting new employee {}",employee);
             employeeService.insertEmployee(employee);
             return "Success";
        }
        return "Fail";
    }
    @DeleteMapping("/delete/{empId}")
    public String delete(@PathVariable Integer empId){
        if(employeeService.findEmployeeById(empId) != null){
            logger.warn("Deleting empId {}",empId);
            employeeService.deleteEmployee(empId);
            return "Removed";
        }
        return "Failed";
    }
}
