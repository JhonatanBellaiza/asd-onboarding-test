package edu.miu.employeemanagementsystem.service;

import edu.miu.employeemanagementsystem.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> createEmployee(Employee employee);
    Optional<Employee> findEmploye(String employeeName);
    Optional<Employee> updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);

    Optional<List<Employee>> findEmployees();
}
