package com.AulaCube.Employee_Management.dto;

import java.sql.Timestamp;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {

	 @Id
	    private String departmentId;

	    private String departmentName;

	    @Field(name = "created_at")
	    private Timestamp createdAt;

	    @Field(name = "updated_at")
	    private Timestamp updatedAt;
	    
	    

		public String getDepartmentId() {
			return departmentId;
		}



		public void setDepartmentId(String departmentId) {
			this.departmentId = departmentId;
		}



		public String getDepartmentName() {
			return departmentName;
		}



		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}



		public Timestamp getCreatedAt() {
			return createdAt;
		}



		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}



		public Timestamp getUpdatedAt() {
			return updatedAt;
		}



		public void setUpdatedAt(Timestamp updatedAt) {
			this.updatedAt = updatedAt;
		}



		public Department(String departmentId, String departmentName, Timestamp createdAt, Timestamp updatedAt) {
			super();
			this.departmentId = departmentId;
			this.departmentName = departmentName;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}
	    
	    

	    // Constructors, getters, and setters
	    
	    
}
