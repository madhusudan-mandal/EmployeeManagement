package com.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
