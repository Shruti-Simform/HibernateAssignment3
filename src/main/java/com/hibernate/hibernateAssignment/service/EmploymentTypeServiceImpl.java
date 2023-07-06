package com.hibernate.hibernateAssignment.service;

import com.hibernate.hibernateAssignment.entity.EmploymentType;
import com.hibernate.hibernateAssignment.repository.EmploymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmploymentTypeServiceImpl implements EmploymentTypeService{
    @Autowired
    EmploymentTypeRepository employmentTypeRepository;
    @Override
    public List<EmploymentType> getAllEmploymentType() {
        return employmentTypeRepository.findAll();
    }

    @Override
    public EmploymentType getById(Integer id) {
        return employmentTypeRepository.findById(id).get();
    }

    @Override
    public EmploymentType insertEmploymentType(EmploymentType employmentType) {
        return employmentTypeRepository.save(employmentType);
    }
}
