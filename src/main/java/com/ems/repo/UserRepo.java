package com.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.dto.UserDto;
import com.ems.model.entity.User;
public interface UserRepo extends JpaRepository<User, Long>{
	UserDto findByUserName(String name);
}
