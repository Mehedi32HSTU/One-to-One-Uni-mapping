package com.spring.rest.model;

import javax.persistence.*;

@Entity
@Table(name="personal_info")
public class PersonalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long Id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Mobile")
	private String mobile;

	@Column(name="Address")
	private String address;

	public PersonalDetails() {
		
	}

	public PersonalDetails(String name, String email, String mobile, String address) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
