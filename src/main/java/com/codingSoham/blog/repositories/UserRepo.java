package com.codingSoham.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingSoham.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}