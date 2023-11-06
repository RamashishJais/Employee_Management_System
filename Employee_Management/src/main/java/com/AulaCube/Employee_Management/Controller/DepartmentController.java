package com.AulaCube.Employee_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AulaCube.Employee_Management.Service.DepartmentService;
import com.AulaCube.Employee_Management.dto.Department;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/saveDepartment")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        return ResponseEntity.ok(createdDepartment);
    }

    @GetMapping("/getAllDepartment")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/getBydepId/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }

    @PutMapping("/updateBydepId/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String departmentId, @RequestBody Department department) {
        // Ensure the request body's departmentId matches the path variable departmentId
        if (!departmentId.equals(department.getDepartmentId())) {
            return ResponseEntity.badRequest().build();
        }
        Department updatedDepartment = departmentService.updateDepartment(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/deleteBydepId/{departmentId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.noContent().build();
    }
}
