package com.kirana.employeedirectory.service.impl;

import com.kirana.employeedirectory.entity.Employee;
import com.kirana.employeedirectory.repository.EmployeeRepository;
import com.kirana.employeedirectory.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {

        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }
        return theEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee) ;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (id == null){
            throw new RuntimeException("Employee with id not found");
        }
        employeeRepository.deleteById(id);
    }


}
