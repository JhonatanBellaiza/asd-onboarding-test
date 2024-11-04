package edu.miu.employeemanagementsystem.service.impl;

import edu.miu.employeemanagementsystem.model.Employee;
import edu.miu.employeemanagementsystem.repository.EmployeeRepository;
import edu.miu.employeemanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> createEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return Optional.of(savedEmployee);
    }

    @Override
    public Optional<Employee> findEmploye(String employeeName) {
        return employeeRepository.findEmployeeByFirstName(employeeName);
    }


    @Override
    public Optional<Employee> updateEmployee(Employee employee) {
        return Optional.of(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<List<Employee>> findEmployees() {
        return Optional.of(employeeRepository.findAll());
    }
}
