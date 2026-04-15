package com.practice.domain.post;

import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	public Post findById(Long id) {
		return postRepository.findById(id);
	}
	
}