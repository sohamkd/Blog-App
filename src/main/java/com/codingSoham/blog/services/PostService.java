package com.codingSoham.blog.services;

import java.util.List;

import com.codingSoham.blog.entities.Post;
import com.codingSoham.blog.payloads.PostDto;
import com.codingSoham.blog.payloads.PostResponse;

public interface PostService  {
	
	// create

		PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

		// update
		PostDto updatePost(PostDto postDto, Integer postId);

		// delete
		void deletePost(Integer postId);

		// get all post
		PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
		// get single Post

		PostDto getPostById(Integer postId);

		// get all posts by category
		List<PostDto> getPostsByCategory(Integer categoryId);

		// get all posts by user
		List<PostDto> getPostByUser(Integer userId);

		// get search posts
		List<PostDto> searchPosts(String keyword);

}