package com.hibernate.hibernateAssignment.repository;

import com.hibernate.hibernateAssignment.entity.FullTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullTimeEmployeeRepository extends JpaRepository<FullTimeEmployee,Integer> {
}
