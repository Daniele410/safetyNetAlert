package com.safetyNetAlert.safetyNetAlert.dto;

import java.util.List;

public class HouseHolderDto {
	private String firstName;
	private String lastName;
	private int age;
	private List<String> medications;
	private List<String> allergies;
	
	
	
	
	public HouseHolderDto(String firstName, String lastName, int age, List<String> medications,
			List<String> allergies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getMedications() {
		return medications;
	}
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	
	
	
}