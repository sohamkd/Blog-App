package com.codingSoham.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codingSoham.blog.entities.User;
import com.codingSoham.blog.exceptions.ResourceNotFoundException;
import com.codingSoham.blog.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// loading use4 from database by user name

			User user = this.userRepo.findByEmail(username)
					.orElseThrow(() -> new ResourceNotFoundException("User", "email :" + username, 0));

			return user;
	}

}
