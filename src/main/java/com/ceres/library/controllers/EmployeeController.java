package com.ceres.library.controllers;

import com.ceres.library.entities.Employee;
import com.ceres.library.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    List<Employee> getAll(){
        return  employeeService.getAll();
    }
    @GetMapping("/{id}")
    Optional<Employee> getOne(@PathVariable("id") Long id){
        return employeeService.getOne(id);
    }
    @PostMapping
    Employee saveEmp(@RequestBody Employee employee){
        return  employeeService.createEmp(employee);
    }
    @PutMapping
    Employee updateEmp(@RequestBody Employee employee){
        return employeeService.updateEmp(employee);
    }
    @DeleteMapping("/{id}")
    void delEmp(@PathVariable("id") Long id){
        employeeService.delEmployee(id);
    }

}
