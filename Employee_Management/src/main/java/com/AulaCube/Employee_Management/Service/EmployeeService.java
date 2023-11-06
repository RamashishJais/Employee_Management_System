package com.AulaCube.Employee_Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AulaCube.Employee_Management.Exception.EmployeeNotFoundException;
import com.AulaCube.Employee_Management.Repository.EmployeeRepository;
import com.AulaCube.Employee_Management.dto.Employee;
@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeRepository createEmployee(EmployeeRepository employee) {
        // Implement any necessary business logic
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        Employee employee = (Employee) employeeRepository.findById(id).orElse(null);
         if(employee==null) {
        	 throw new EmployeeNotFoundException(id);
        	 
         }
         return employee;
    }

    public List<EmployeeRepository> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeRepository updateEmployee(EmployeeRepository employee) {
        // Implement any necessary business logic
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
 