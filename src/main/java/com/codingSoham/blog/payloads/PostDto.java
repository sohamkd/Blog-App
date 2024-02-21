package com.codingSoham.blog.payloads;

import java.time.LocalDate;

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
}
