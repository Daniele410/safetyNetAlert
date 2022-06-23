package com.safetyNetAlert.safetyNetAlert.dto;

import java.util.List;

public class FloodDto {


	private String lastName;
	private String phone;
	private int age;
	private String address;
	private List<String> medications;
	private List<String> allergies;
	
	
		
	public FloodDto(String lastName, String phone, int age, String address, List<String> medications,
			List<String> allergies) {
		
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.address = address;
		this.medications = medications;
		this.allergies = allergies;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
