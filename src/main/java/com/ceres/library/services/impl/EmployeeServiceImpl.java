package com.ceres.library.services.impl;

import com.ceres.library.entities.Employee;
import com.ceres.library.repositories.EmployeeRepository;
import com.ceres.library.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getOne(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee createEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
