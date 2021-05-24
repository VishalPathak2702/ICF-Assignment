package com.app.ICFassessment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.ICFassessment.model.Employee;
import com.app.ICFassessment.repo.EmployeeRepo;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	//save the employee
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee )
	{
		employeeRepo.save(employee);
		return "Employee Save Successfully!";
	}
	
	
	//select the employee
	@GetMapping("/get")
	public List<Employee> getEmployee()
	{
		return employeeRepo.findAll();
	}
	
	
	//Update the employee
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		Optional<Employee> e=employeeRepo.findById(employee.getId());
		Employee emp=e.get();
		emp.setId(employee.getId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setStartDate(employee.getStartDate());
		emp.setDesignation(employee.getDesignation());
		emp.setDepartment(employee.getDepartment());
		emp.setEndDate(employee.getEndDate());
		emp.setStatus(employee.getStatus());
		emp.setDateOfBirth(employee.getDateOfBirth());
		emp.setReportingManager(employee.getReportingManager());
		emp.setGender(employee.getGender());
		emp.setBloodGroup(employee.getBloodGroup());
		emp.setAddress(employee.getAddress());
		employeeRepo.save(emp);
		return emp;	
		
		
		
	}
	
	//Delete the employee
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id)
	{
		employeeRepo.deleteById(id);
		return "Succefully delete data";
	}

}
