package com.hibernate.hibernateAssignment.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "EmployeeType")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FullTimeEmployee.class, name = "fullTime"),
        @JsonSubTypes.Type(value = PartTimeEmployee.class, name = "partTime")
})
public abstract class EmploymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "employmentType")
    @JsonIgnore
    List<Employee> employmentTypes = new ArrayList<>();
    public EmploymentType() {
    }

    public EmploymentType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
