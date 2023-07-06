package com.hibernate.hibernateAssignment.repository;

import com.hibernate.hibernateAssignment.entity.PartTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartTimeEmployeeRepository extends JpaRepository<PartTimeEmployee,Integer> {
}
