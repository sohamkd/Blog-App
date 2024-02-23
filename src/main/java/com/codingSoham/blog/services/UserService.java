package com.codingSoham.blog.services;

import java.util.List;

import com.codingSoham.blog.payloads.UserDto;

public interface UserService {

	UserDto registerNewUser(UserDto userDto);
	
	UserDto createuser(UserDto userDto);
	UserDto updateUser(UserDto userDto,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
	
}
