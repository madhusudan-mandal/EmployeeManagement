package com.ems.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.exception.ResourceNotFoundException;
import com.ems.model.dto.DepartmentDto;
import com.ems.model.entity.Department;
import com.ems.model.entity.Employee;
import com.ems.repo.DepartmentRepo;
import com.ems.repo.EmployeeRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl {

    @Autowired
    private DepartmentRepo departmentRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private EmployeeRepo employeeRepo;

    private DepartmentDto convertToDTO(Department department) {
        return this.modelMapper.map(department, DepartmentDto.class);
    }

    private Department convertToEntity(DepartmentDto departmentDto) {
        return this.modelMapper.map(departmentDto, Department.class);
    }

    public List<DepartmentDto> getAllDepartments() {
        return departmentRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        return convertToDTO(department);
    }

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = convertToEntity(departmentDto);
        Department savedDepartment = departmentRepo.save(department);
        return convertToDTO(savedDepartment);
    }

    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        department.setName(departmentDto.getName());
        department.setHeadOfDepartment(departmentDto.getHeadOfDepartment());
        Department updatedDepartment = departmentRepo.save(department);
        return convertToDTO(updatedDepartment);
    }

    public void deleteDepartment(Long id) {
    	Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    	List<Employee> employees = employeeRepo.findByDepartmentId(id);
    	if(employees.isEmpty())
    	{
    		throw new RuntimeException("Departement have employee assigned to it, can't delete");
    	}
    	departmentRepo.delete(department);
    }
}