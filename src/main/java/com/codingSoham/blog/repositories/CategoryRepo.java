package com.codingSoham.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingSoham.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}