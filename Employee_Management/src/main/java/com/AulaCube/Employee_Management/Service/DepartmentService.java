package com.AulaCube.Employee_Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AulaCube.Employee_Management.Exception.DepartmentNotFoundException;
import com.AulaCube.Employee_Management.Repository.DepartmentRepository;
import com.AulaCube.Employee_Management.dto.Department;

@Service
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {
        // Implement any necessary business logic
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(String departmentId) {
        Department department= departmentRepository.findById(departmentId).orElse(null);
        if(department==null) {
        	throw new DepartmentNotFoundException(departmentId);
        }
        return department;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Department department) {
        // Implement any necessary business logic
        return departmentRepository.save(department);
    }

    public void deleteDepartment(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
