package com.AulaCube.Employee_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AulaCube.Employee_Management.Repository.EmployeeRepository;
import com.AulaCube.Employee_Management.Service.EmployeeService;
import com.AulaCube.Employee_Management.dto.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/employees")
@Api(tags = "Employee API")
public class EmployeeController {

	 private final EmployeeService employeeService;

	    @Autowired
	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }

	    @PostMapping(value = "/saveEmployee")
	    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	        Employee createdEmployee = (Employee) employeeService.createEmployee((EmployeeRepository) employee);
	        return ResponseEntity.ok(createdEmployee);
	    }

	    @GetMapping(value="/getAllEmployee")
	    public ResponseEntity<List<EmployeeRepository>> getAllEmployees() {
	        List<EmployeeRepository> employees = employeeService.getAllEmployees();
	        return ResponseEntity.ok(employees);
	    }

	    @GetMapping("/getByempId/{id}")
	    @ApiOperation("Get an employee by Id")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
	        Employee employee = employeeService.getEmployeeById(id);
	        return ResponseEntity.ok(employee);
	    }

	    @PutMapping("/updateByempId/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	        // Ensure the request body's ID matches the path variable ID
	        if (!id.equals(employee.getId())) {
	            return ResponseEntity.badRequest().build();
	        }
	        Employee updatedEmployee = (Employee) employeeService.updateEmployee((EmployeeRepository) employee);
	        return ResponseEntity.ok(updatedEmployee);
	    }

	    @DeleteMapping("/deleteById/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.noContent().build();
	    }
}
