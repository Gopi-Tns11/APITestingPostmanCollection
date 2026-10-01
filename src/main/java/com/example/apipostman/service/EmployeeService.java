package com.example.apipostman.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.apipostman.entity.Employee;
import com.example.apipostman.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployee(Long id, Employee employeeDetails) {

        return employeeRepository.findById(id).map(employee -> {

            employee.setName(employeeDetails.getName());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setSalary(employeeDetails.getSalary());
            employee.setEmail(employeeDetails.getEmail());

            return employeeRepository.save(employee);
        });
    }

    public boolean deleteEmployee(Long id) {

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }

        return false;
    }
}