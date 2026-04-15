package com.practice.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Post {
	
	private Long postId;
	private String title;
	private String content;
	private String createdAt;
	
}