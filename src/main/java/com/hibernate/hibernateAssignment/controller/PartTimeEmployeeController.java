package com.hibernate.hibernateAssignment.controller;

import com.hibernate.hibernateAssignment.entity.PartTimeEmployee;
import com.hibernate.hibernateAssignment.repository.PartTimeEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/partTime")
public class PartTimeEmployeeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PartTimeEmployeeRepository partTimeEmployeeRepository;
    @GetMapping("/get")
    public List<PartTimeEmployee> getAll(){
        logger.info("Retrieved all part time details");
        return partTimeEmployeeRepository.findAll();
    }
    @GetMapping("/get/{id}")
    public PartTimeEmployee getByID(@PathVariable Integer id){
        logger.info("Retrieved part time id {}",id);
        return partTimeEmployeeRepository.findById(id).get();
    }
    @PostMapping("/add")
    public PartTimeEmployee insert(@RequestBody PartTimeEmployee partTimeEmployee){
        logger.info("Inserted {}",partTimeEmployee);
        return partTimeEmployeeRepository.save(partTimeEmployee);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        logger.warn("Deleted id {}",id);
        partTimeEmployeeRepository.deleteById(id);
        return partTimeEmployeeRepository.findById(id).isEmpty()?"Success":"Fail";
    }
}
