package com.example.demo.dto;

import java.util.List;

public class EmployeeDTO {
	private Long id;
	private String name;
	private String city;
	private String country;
	private String dob;
	private List<DependentDTO> dependents;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public List<DependentDTO> getDependents() {
		return dependents;
	}
	public void setDependents(List<DependentDTO> dependents) {
		this.dependents = dependents;
	}
	
	
	
}
