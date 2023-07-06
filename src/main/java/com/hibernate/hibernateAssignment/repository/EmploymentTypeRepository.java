package com.hibernate.hibernateAssignment.repository;

import com.hibernate.hibernateAssignment.entity.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentTypeRepository extends JpaRepository<EmploymentType,Integer> {

}
