package edu.miu.employeemanagementsystem;

import edu.miu.employeemanagementsystem.model.Employee;
import edu.miu.employeemanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeManagementSystemApplication {

	private final EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Employee emp1 = new Employee("John", "Doe", 50000);
			Employee emp2 = new Employee("Jane", "Dona", 50000);
			Employee emp3 = new Employee("Alice", "Smith", 60000);
			Employee emp4 = new Employee("Bob", "Brown", 45000);


			employeeService.createEmployee(emp1);
			employeeService.createEmployee(emp2);
			employeeService.createEmployee(emp3);
			employeeService.createEmployee(emp4);


			//Print Employees by Salary
			List<Employee> employees = employeeService.findEmployees().get();

			Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getFirstName);
			Comparator<Employee> employeeSalaryComparator = Comparator.comparing(Employee::getSalary);

			Comparator<Employee> finalComparator = employeeSalaryComparator.thenComparing(employeeNameComparator.reversed());

			List<Employee> sortedList = employees.stream()
					.sorted(finalComparator)
					.collect(Collectors.toList());

			sortedList.forEach(emp -> System.out.println(emp.toString()));

		};

	}

}
