package com.ems.service;

import java.util.List;

import com.ems.model.dto.UserDto;
import com.ems.model.entity.User;

public interface UserService {
	public UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto);
	UserDto getUserById(Long id);
	List<UserDto> getUsers();
	void deleteUser(long id);
	
}
