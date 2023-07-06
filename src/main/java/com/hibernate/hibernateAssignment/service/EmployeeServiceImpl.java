package com.hibernate.hibernateAssignment.service;

import com.hibernate.hibernateAssignment.entity.Address;
import com.hibernate.hibernateAssignment.entity.Department;
import com.hibernate.hibernateAssignment.entity.Employee;
import com.hibernate.hibernateAssignment.entity.EmploymentType;
import com.hibernate.hibernateAssignment.repository.DepartmentRepository;
import com.hibernate.hibernateAssignment.repository.EmployeeRepository;
import com.hibernate.hibernateAssignment.repository.EmploymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmploymentTypeRepository employmentTypeRepository;
    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }
    public Employee findEmployeeById(Integer empId){
        return employeeRepository.findById(empId).get();
    }
    public Employee insertEmployee(Employee employee){
        Employee currentEmployee =  new Employee();
        currentEmployee.setEmpId(employee.getEmpId());
        currentEmployee.setEmpName(employee.getEmpName());

        Address address = new Address();
        address.setStreet(employee.getAddress().getStreet());
        address.setCity(employee.getAddress().getCity());
        address.setState(employee.getAddress().getState());
        currentEmployee.setAddress(address);

        Department department = departmentRepository.findById(employee.getDepartment().getDeptId()).get();
        currentEmployee.setDepartment(department);

        EmploymentType employmentType = employmentTypeRepository.findById(employee.getEmploymentType().getId()).get();
        currentEmployee.setEmploymentType(employmentType);

        return employeeRepository.save(currentEmployee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        employeeRepository.deleteById(empId);
    }
}
