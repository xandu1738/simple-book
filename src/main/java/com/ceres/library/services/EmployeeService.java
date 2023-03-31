package com.ceres.library.services;

import com.ceres.library.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAll();
    Optional<Employee> getOne(Long id);
    Employee createEmp(Employee employee);
    Employee updateEmp(Employee employee);
    void delEmployee(Long id);
}
