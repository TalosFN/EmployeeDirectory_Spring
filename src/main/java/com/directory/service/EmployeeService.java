package com.directory.service;

import java.util.List;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.directory.dto.EmployeeDTO;
import com.directory.entity.EmployeeEntity;
import com.directory.repository.EmployeeRepository;
@Service

public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<EmployeeEntity> employees() {
		employeeRepository.findAll().forEach(System.out::println);
        return employeeRepository.findAll();
        
    }
	
	public EmployeeEntity employee(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow();
    }
	
	public ResponseEntity<EmployeeEntity> createEmployee(EmployeeEntity employee) {
		if(employee.getName() == "" || employee.getPhoneNumber() == "" || employee.getSurname() == "" || employee.getDepartment() == "") {
			return ResponseEntity.badRequest().body(null);
		}
		
        System.out.println(employee.toString());
        return ResponseEntity.ok().body((employeeRepository.save(employee)));
    }
	public EmployeeEntity updateEmployeeInfo(EmployeeEntity chEmployee, Long employeeId) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).orElseThrow();
        if(chEmployee.getName() != "") {
            employee.setName(chEmployee.getName());
        }
        if(chEmployee.getSurname() != "") {
            employee.setSurname(chEmployee.getSurname());
        }
        if(chEmployee.getPhoneNumber() != "") {
            employee.setPhoneNumber(chEmployee.getPhoneNumber());
        }
        if(chEmployee.getDepartment() != "") {
            employee.setDepartment(chEmployee.getDepartment());
        }
        employeeRepository.save(employee);
        return employee;
    }
	
	public EmployeeEntity removeEmployee(Long employeeId) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).orElseThrow();
        employeeRepository.delete(employee);
        return employee;
        
    }
	

}
