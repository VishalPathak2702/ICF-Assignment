package com.app.ICFassessment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ICFassessment.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
