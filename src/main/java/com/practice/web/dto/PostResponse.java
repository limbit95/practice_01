package com.practice.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostResponse {
	
	private Long postId;
	private String title;
	private String content;
	
}