package com.kirana.employeedirectory.controller;

import com.kirana.employeedirectory.entity.Employee;
import com.kirana.employeedirectory.repository.EmployeeRepository;
import com.kirana.employeedirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService,EmployeeRepository employeeRepository){
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/list")
    public String listEmployee(Model theModel){

        List<Employee> employees = employeeRepository.findAllByOrderByLastNameAsc();
        theModel.addAttribute("employees", employees);

        return "/employees/employees-list";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);

        return "/employees/employee-add-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("employee") Employee theEmployee ){

        employeeService.saveEmployee(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate( @RequestParam("employeeId") Long id,Model theModel){

        Employee theEmployee = employeeService.findEmployeeById(id);

            theModel.addAttribute("employee", theEmployee);
        return "employees/employee-add-form";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") Long id){
            employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }
}
