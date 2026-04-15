package com.practice.domain.post;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	private final PostRepository postRepository;
	
	public PostService(PostRepository postRepository) { this.postRepository = postRepository; }
	
	public Post findById(Long id) {
		return findById(id);
	}

	public Long save(Post post) {
		return postRepository.save(post).getPostId();
	}

	public List<Post> findAll() {
		return findAll();
	}
	
}