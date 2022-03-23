package com.spring.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.exception.ResourceNotFoundException;
import com.spring.rest.model.Employee;
import com.spring.rest.repository.EmployeeRepository;


@RestController
@RequestMapping("/onetoone")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	Fetch All Employee
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
//		System.out.println(this.employeeRepository);
		
		return this.employeeRepository.findAll();
	}
	
//	Fetch Single Employee
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable (value="id") Long employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found ::" + employeeId));
		return ResponseEntity.ok().body(employee);
	}
//	Create New Employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
//	Update Employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee( @PathVariable (value="id") Long employeeId, @Validated @RequestBody
			Employee employeeDetails) throws ResourceNotFoundException
	{
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found ::" + employeeId));
		employee.setName(employeeDetails.getName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setDept(employeeDetails.getDept());
		employee.setPersonalDetails(employeeDetails.getPersonalDetails());
		
		return ResponseEntity.ok(this.employeeRepository.save(employee));
	}
//	Delete Employee
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) 
		throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(employeeId)
		        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		this.employeeRepository.delete(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted Successfully.", Boolean.TRUE);
		
		return response;
	}
	
	

}
