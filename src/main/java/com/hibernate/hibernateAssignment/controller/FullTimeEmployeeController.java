package com.hibernate.hibernateAssignment.controller;

import com.hibernate.hibernateAssignment.entity.FullTimeEmployee;
import com.hibernate.hibernateAssignment.repository.FullTimeEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fullTime")
public class FullTimeEmployeeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    FullTimeEmployeeRepository fullTimeEmployeeRepository;
    @GetMapping("/get")
    public List<FullTimeEmployee> getAll(){
        logger.info("Retrieved all full time details");
        return fullTimeEmployeeRepository.findAll();
    }
    @GetMapping("/get/{id}")
    public FullTimeEmployee getByID(@PathVariable Integer id){
        logger.info("Retrieved id {}",id);
        return fullTimeEmployeeRepository.findById(id).get();
    }
    @PostMapping("/add")
    public FullTimeEmployee insert(@RequestBody FullTimeEmployee fullTimeEmployee){
        logger.info("Inserted {}",fullTimeEmployee);
        return fullTimeEmployeeRepository.save(fullTimeEmployee);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        logger.warn("Deleted id {}",id);
        fullTimeEmployeeRepository.deleteById(id);
        return fullTimeEmployeeRepository.findById(id).isEmpty()?"Success":"Fail";
    }
}
