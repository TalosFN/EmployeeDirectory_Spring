package com.directory.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber
				+ ", department=" + department + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public EmployeeEntity() {
		
	}
	
	public EmployeeEntity(String name, String surname, String phoneNumber, String department) {
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.department = department;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	private String name;
    private String surname;
    private String phoneNumber;
    private String department;
   
}


