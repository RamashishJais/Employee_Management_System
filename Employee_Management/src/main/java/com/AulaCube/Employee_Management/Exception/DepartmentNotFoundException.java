package com.AulaCube.Employee_Management.Exception;

public class DepartmentNotFoundException extends RuntimeException{

	public DepartmentNotFoundException(String departmentId) {
        super("Department not found with ID: " + departmentId);
    }
}
