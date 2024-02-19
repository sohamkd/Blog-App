package com.codingSoham.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingSoham.blog.entities.Category;
import com.codingSoham.blog.entities.Post;
import com.codingSoham.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);

}
