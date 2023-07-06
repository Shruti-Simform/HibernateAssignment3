package com.hibernate.hibernateAssignment.controller;

import com.hibernate.hibernateAssignment.entity.EmploymentType;
import com.hibernate.hibernateAssignment.service.EmploymentTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employmentType")
public class EmploymentTypeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EmploymentTypeService employmentTypeService;
    @GetMapping("/get")
    public List<EmploymentType> getAll(){
        logger.info("Retrieving all employment types");
        return employmentTypeService.getAllEmploymentType();
    }
    @GetMapping("/get/{id}")
    public EmploymentType getById(@PathVariable Integer id){
        logger.info("Retrieved id {}",id);
        return employmentTypeService.getById(id);
    }
    @PostMapping("/add")
    public EmploymentType insert(@RequestBody EmploymentType employmentType){
        logger.info("Inserted employment type {}",employmentType);
        return employmentTypeService.insertEmploymentType(employmentType);
    }
}
