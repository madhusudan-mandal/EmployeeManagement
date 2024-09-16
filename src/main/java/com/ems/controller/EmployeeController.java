package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.dto.EmployeeDto;
import com.ems.model.entity.Employee;
import com.ems.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    // Fetch all employees (accessible to Admin)
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<EmployeeDto> getAllEmployees() {
        return employeeServiceImpl.getAllEmployee();
    }

    // Fetch employee by ID (accessible to Admin)
    @GetMapping("/{id}")
    public Optional<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return Optional.of(employeeServiceImpl.getEmployeeById(id));
    }

    // Create new employee (accessible to Admin)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return employeeServiceImpl.createEmployee(employeeDto);
    }

    // Update existing employee (accessible to Admin)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public EmployeeDto updateEmployee(@PathVariable Long id,EmployeeDto employeeDetails) {
        return employeeServiceImpl.updateEmployee(employeeDetails);
    }

    // Delete employee (accessible to Admin)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEmployee(@PathVariable Long id) {
        employeeServiceImpl.deleteEmployee(id);
    }

//    // Fetch logged-in employee details (accessible to Employee)
//    @GetMapping("/me")
//    @PreAuthorize("hasRole('EMPLOYEE')")
//    public Optional<Employee> getLoggedInEmployeeDetails(@RequestParam String username) {
//        // Assuming that Employee entity has a username field and the service method is implemented to find employee by username
//        return employeeServiceImpl.getEmployeeByUsername(username);
//    }
    
    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
	public EmployeeDto updatePerformance(Long id, EmployeeDto employeeDto) {
    	return employeeServiceImpl.updatePerformance(id, employeeDto);
    }
}