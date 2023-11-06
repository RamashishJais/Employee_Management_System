package com.AulaCube.Employee_Management.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<com.AulaCube.Employee_Management.dto.Department, String>{

}
