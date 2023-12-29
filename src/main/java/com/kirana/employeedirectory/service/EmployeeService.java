package com.kirana.employeedirectory.service;

import com.kirana.employeedirectory.entity.Employee;

import java.util.List;
import java.util.Optional;
public interface EmployeeService {

    List<Employee> findAll();

    Employee findEmployeeById(Long id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(Long id);
}
