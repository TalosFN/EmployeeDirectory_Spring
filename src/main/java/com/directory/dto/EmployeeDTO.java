package com.directory.dto;


import com.directory.entity.EmployeeEntity;

public class EmployeeDTO {
	
	private Long id;
	private String name;
	private String surname;
	private String phoneNumber;
	private String department;
	
	
	
	public EmployeeDTO(Long id, String name, String surname, String phoneNumber, String department) {
		
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.department = department;
	}



	public static EmployeeDTO toEmployeeDTO(EmployeeEntity employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getSurname(), employee.getPhoneNumber(), employee.getDepartment());
    }
}
