package com.example.apipostman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apipostman.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}