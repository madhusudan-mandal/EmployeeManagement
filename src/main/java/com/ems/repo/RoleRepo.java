package com.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.entity.Roles;

public interface RoleRepo extends JpaRepository<Roles,Long>{
	Roles findByName(String name);
}
