package com.practice.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.domain.post.Post;
import com.practice.domain.post.PostService;


@Controller
public class PostPageController {
	
	private final PostService postService;
	
	public PostPageController(PostService postService) { this.postService = postService; }
	
	@GetMapping("/")
	public String getIndex() {
		return "/index";
	}
	
	@GetMapping("/posts")
	public String getPostPage(Model model) {
		
		List<Post> postList = postService.findAll();

		model.addAttribute("postList", postList);
		
		return "/post/list";
	}
	
	@GetMapping("/posts/{id}")
	public String getPost(Long id, Model model) {
		
		Post post = postService.findById(id);
		
		model.addAttribute("post", post);
		
		return "/post/view";
	}
	
	@GetMapping("/posts/new")
	public String getWritePage() {
		return "/post/write";
	}
	
	@PostMapping("/posts")
	public String writePost(@ModelAttribute Post post,
							Model model) {
		
		Long result = postService.save(post);
		
		if(result == 0) {
			model.addAttribute("message", "등록 실패하였습니다.");
		}
		
		model.addAttribute("message", "정상 처리되었습니다.");
		
		return "redirect:/posts";
	}
	
}