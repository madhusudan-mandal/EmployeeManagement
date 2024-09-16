package com.ems.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ems.exception.ResourceNotFoundException;
import com.ems.model.dto.UserDto;
import com.ems.model.entity.Roles;
import com.ems.model.entity.User;
import com.ems.repo.RoleRepo;
import com.ems.repo.UserRepo;
import com.ems.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = convertToEntity(userDto);
		return convertToDTO(userRepo.save(user));
		
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userDto.getId()).orElseThrow(()->
			new ResourceNotFoundException("User not exist"));
		 user.setUserName(userDto.getName());
		return convertToDTO(userRepo.save(user));
	}

	@Override
	public UserDto getUserById(Long id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User not exist"));
		return convertToDTO(user);
	}

	@Override
	public List<UserDto> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll().stream()
				.map(this::convertToDTO).collect(Collectors.toList());
	}
	
	@Override
	public void deleteUser(long id)
	{
		User user = userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User not exist"));
		userRepo.delete(user);
	}
	
	  // Convert User entity to UserDTO
    private UserDto convertToDTO(User user) {
        Set<String> roles = user.getRoles().stream().map(role -> role.getName()).collect(Collectors.toSet());
        return new UserDto(user.getUserId(), user.getUserName(), roles);
    }

    // Convert UserDTO to User entity
    private User convertToEntity(UserDto userDTO) {
        User user = new User();
        user.setUserName(userDTO.getName());
        user.setUserPassword(passwordEncoder.encode("defaultPassword")); // In real-world, handle password properly
        // Set roles or other fields if needed
        return user;
    }

}
