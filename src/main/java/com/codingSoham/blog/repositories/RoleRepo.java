package com.codingSoham.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingSoham.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{
	
	

}
