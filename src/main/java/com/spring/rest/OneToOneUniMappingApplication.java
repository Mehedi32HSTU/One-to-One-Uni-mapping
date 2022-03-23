package com.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.rest.model.Employee;
import com.spring.rest.model.PersonalDetails;
import com.spring.rest.repository.EmployeeRepository;

@SpringBootApplication
public class OneToOneUniMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneUniMappingApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String ...args) throws Exception{
		Employee employee = new Employee("Mehedi","mehedi@nsl.com","Software");
		PersonalDetails personalDetails = new PersonalDetails("Mehedi","mehedi@gmail.com","01753250010","Uttara");
		employee.setPersonalDetails(personalDetails);
		employeeRepository.save(employee);
	}

}
