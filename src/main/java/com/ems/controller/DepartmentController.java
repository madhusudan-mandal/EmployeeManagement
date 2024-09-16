package com.ems.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.dto.DepartmentDto;
import com.ems.service.impl.DepartmentServiceImpl;

@RestController
@RequestMapping("/api/DepartmentDtos")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    @GetMapping
    public List<DepartmentDto> getAllDepartmentDtos() {
        return departmentServiceImpl.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable Long id) {
        return (DepartmentDto) departmentServiceImpl.getDepartmentById(id);
    }

    @PostMapping
    public DepartmentDto createDepartmentDto(DepartmentDto DepartmentDto) {
        return departmentServiceImpl.createDepartment(DepartmentDto);
    }

    @PutMapping("/{id}")
    public DepartmentDto updateDepartmentDto(@PathVariable Long id, DepartmentDto DepartmentDtoDetails) {
        return departmentServiceImpl.updateDepartment(id, DepartmentDtoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentDto(@PathVariable Long id) {
        departmentServiceImpl.deleteDepartment(id);
    }
}