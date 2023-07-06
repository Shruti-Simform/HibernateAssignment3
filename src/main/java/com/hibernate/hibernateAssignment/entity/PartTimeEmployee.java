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
@Table(name = "part_time")
public class PartTimeEmployee extends EmploymentType{
    private Integer stipend;
    private String workingShift;
    private String employeeTypePart="PartTimeEmployee";
    public PartTimeEmployee() {
//        super();
    }

    public PartTimeEmployee(Integer stipend, String workingShift) {
        super();
        this.stipend = stipend;
        this.workingShift = workingShift;
    }
}
