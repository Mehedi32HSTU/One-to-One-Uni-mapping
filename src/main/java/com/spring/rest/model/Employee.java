package com.spring.rest.model;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long Id;
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="Dept.")
	private String dept;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="personal_info")
	private PersonalDetails personalDetails;
		
	public Employee() {
		
	}

	public Employee(String name, String email, String dept) {
		super();
		this.name = name;
		this.email = email;
		this.dept = dept;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	
	
	
	
	

}
