package com.directory.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.directory.entity.*;
import com.directory.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class WebController {
	
	private final EmployeeService employeeService;
	
	public WebController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
	
	@GetMapping()
	public String employees(Model model) {
		
		model.addAttribute("employees", employeeService.employees());
		
		return "employees";
	}
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("employee" ,employeeService.employee(id));
		return "index";
	}
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("employee", new EmployeeEntity());
		
		return "createForm";
	}
	
	@PostMapping()
	public String createEmployee(@ModelAttribute("employee") EmployeeEntity employee) {
		employeeService.createEmployee(employee);
		return "redirect:/employee";
	}
	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("employee", employeeService.employee(id));
			return "update";
		
	}
	 @PostMapping("/{id}")
	    public String update(@ModelAttribute("employee") EmployeeEntity employee, @PathVariable("id") Long id) {
	        employeeService.updateEmployeeInfo(employee, id);
	        return "redirect:/employee";
	    }
	 @PostMapping("/{id}/delete")
		 public String delete(@PathVariable("id") Long id) {
		 employeeService.removeEmployee(id);
		 System.out.println("reeeeeeeeeeeeeeeeeeeeeee");
		 return "redirect:/employee";
		 
	 }
	 
	}

	


