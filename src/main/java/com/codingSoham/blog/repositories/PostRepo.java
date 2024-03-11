package com.codingSoham.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingSoham.blog.entities.Category;
import com.codingSoham.blog.entities.Post;
import com.codingSoham.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	@Query("SELECT p FROM Post p WHERE p.title LIKE :title")
    List<Post> searchByTitle(@Param("title") String title);
}