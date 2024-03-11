package com.codingSoham.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingSoham.blog.entities.User;
import com.codingSoham.blog.exceptions.ResourceNotFoundException;
import com.codingSoham.blog.payloads.UserDto;
import com.codingSoham.blog.repositories.UserRepo;
import com.codingSoham.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public UserDto createuser(UserDto userDto) {
			User user=this.modelMapper.map(userDto,User.class);
			User savedUser=this.userRepo.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "UserId",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		User updateUser = this.userRepo.save(user);
		
		return this.modelMapper.map(updateUser,UserDto.class);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","UserId",userId));
		return this.modelMapper.map(user,UserDto.class);
	}
	

	@Override
	public List<UserDto> getAllUsers() {
		List<User> allUsers=this.userRepo.findAll();
		List<UserDto> allUserDto= allUsers.stream().map((user)->this.modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
		return allUserDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","UserId",userId));
		this.userRepo.delete(user);
		
	}

}