package com.practice.domain.post;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="POST")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long postId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="CREATED_AT")
	private LocalDateTime createdAt;
	
	protected Post() {}
	
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
		this.createdAt = createdAt.now();
	}
	
}