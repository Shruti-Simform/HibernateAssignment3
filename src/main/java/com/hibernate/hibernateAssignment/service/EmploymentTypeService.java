package com.hibernate.hibernateAssignment.service;

import com.hibernate.hibernateAssignment.entity.EmploymentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmploymentTypeService {
    public List<EmploymentType> getAllEmploymentType();
    public EmploymentType getById(Integer id);
    public EmploymentType insertEmploymentType(EmploymentType employmentType);
}
