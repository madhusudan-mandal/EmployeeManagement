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

import com.ems.model.dto.UserDto;
import com.ems.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userServiceImpl.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserDto> getUserById(@PathVariable Long id) {
        return Optional.ofNullable(userServiceImpl.getUserById(id));
    }

    @PostMapping
    public UserDto createUser(UserDto user) {
        return userServiceImpl.createUser(user);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id,UserDto userDetails) {
        return userServiceImpl.updateUser(userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
    }
}