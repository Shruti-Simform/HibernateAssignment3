package com.hibernate.hibernateAssignment.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "full_time")
public class FullTimeEmployee extends EmploymentType {


    private Integer salary;
    private String workingShift;
    private String employeeTypePart="FullTimeEmployee";

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(Integer salary, String workingShift) {
        super();
        this.salary = salary;
        this.workingShift = workingShift;
    }
}
