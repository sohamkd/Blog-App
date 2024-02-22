package com.codingSoham.blog.payloads;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.codingSoham.blog.entities.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

	private Integer postid;

	private String title;
	
	private String content;
	
	private String imageName;

	private LocalDate addeddate;

	private CategoryDto category;

	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>(); //whenever we will fetch posts ,automatically comments will be retrieved
	
}
