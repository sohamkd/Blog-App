package com.codingSoham.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingSoham.blog.entities.Comment;
import com.codingSoham.blog.entities.Post;
import com.codingSoham.blog.exceptions.ResourceNotFoundException;
import com.codingSoham.blog.payloads.CommentDto;
import com.codingSoham.blog.repositories.CommentRepo;
import com.codingSoham.blog.repositories.PostRepo;
import com.codingSoham.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	

	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CommentRepo commentRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));

		Comment comment=this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);

	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));

		this.commentRepo.delete(com);

	}

}
