package com.codingSoham.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingSoham.blog.entities.Comment;


public interface CommentRepo  extends JpaRepository<Comment, Integer>{


}