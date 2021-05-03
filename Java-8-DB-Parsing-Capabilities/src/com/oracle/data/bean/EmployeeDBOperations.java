package com.oracle.data.bean;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeDBOperations {

	public static void main(String[] args) {
		
		//How many male and female employees are there in the organization?
		Map<String, Long> noOfMaleAndFemaleEmployees = Employee.getEmployeeList().stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("noOfMaleAndFemaleEmployees "+noOfMaleAndFemaleEmployees);
		
		System.out.println("====================================================");
		
		//Print the name of all departments in the organization?
		Employee.getEmployeeList().stream()
		.map(Employee::getDepartment)
		.distinct()
		.forEach(System.out::println);

		System.out.println("====================================================");
		
		//What is the average age of male and female employees
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees = Employee.getEmployeeList().stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge)));
		System.out.println("avgAgeOfMaleAndFemaleEmployees "+avgAgeOfMaleAndFemaleEmployees);

		System.out.println("====================================================");
		
		//Get the details of highest paid employee in the organization?
		Optional<Employee> highestPaidEmployeeWrapper = Employee.getEmployeeList().stream()
		.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println("highestPaidEmployee "+highestPaidEmployeeWrapper.get().toString());

		System.out.println("====================================================");
		
		//Get the names of all employees who have joined after 2015?
		Employee.getEmployeeList().stream()
		.filter(emp -> emp.getYearOfJoining()>=2015)
		.map(Employee::getName)
		.distinct()
		.forEach(System.out::println);

		System.out.println("====================================================");
		
		//Count the number of employees in each department?
		Map<String, Long> employeesInEachDepartment = Employee.getEmployeeList().stream()
		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Employees In Each Department");
		System.out.println(employeesInEachDepartment);

		System.out.println("====================================================");
		
		//What is the average salary of each department?
		Map<String, Double> averageSalaryOfEachDepartment = Employee.getEmployeeList().stream()
		.collect(Collectors.groupingBy(Employee::getDepartment, 
				Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("averageSalaryOfEachDepartment");
		System.out.println(averageSalaryOfEachDepartment);

		System.out.println("====================================================");
		
		//Get the details of youngest male employee in the product development department?
		Optional<Employee> youngestEmployee = Employee.getEmployeeList().stream()
		.filter(data -> data.getGender().equalsIgnoreCase("Male"))
		.min(Comparator.comparing(Employee::getAge));
		System.out.println(youngestEmployee.get().toString());

		System.out.println("====================================================");
		
		//Who has the most working experience in the organization?
		Optional<Employee> mostExperiencedEmployee = Employee.getEmployeeList().stream()
		.min(Comparator.comparing(Employee::getYearOfJoining));
		System.out.println(mostExperiencedEmployee.get().toString());

		System.out.println("====================================================");
		
		//How many male and female employees are there in the sales and marketing team?
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = Employee.getEmployeeList().stream()
		.filter(e -> e.getDepartment()=="Sales And Marketing")
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countMaleFemaleEmployeesInSalesMarketing);

		System.out.println("====================================================");
		
		//What is the average salary of male and female employees?
		Map<String, Double> averageSalMaleFemale = Employee.getEmployeeList().stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(averageSalMaleFemale);
		
		System.out.println("====================================================");
		
		//List down the names of all employees in each department?
		Map<String, List<Employee>> employeeListByDepartment   = Employee.getEmployeeList().stream()
		.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(employeeListByDepartment);
	}
}
