package com.practice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.practice.domain.post.Post;
import com.practice.domain.post.PostService;


@Controller
public class PostPageController {
	
	private PostService postService;
	
	@GetMapping("/posts")
	public String getPostPage() {
		return "/post/list";
	}
	
	@GetMapping("/posts/{id}")
	public String getPost(Long id, Model model) {
		
		Post post = postService.findById(id);
		
		model.addAttribute("post", post);
		
		return "/post/view";
	}
	
}