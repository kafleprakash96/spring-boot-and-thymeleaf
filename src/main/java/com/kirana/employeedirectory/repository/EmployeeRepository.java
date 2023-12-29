package com.kirana.employeedirectory.repository;

import com.kirana.employeedirectory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllByOrderByLastNameAsc();

}
