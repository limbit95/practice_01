package com.practice.domain.post;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<Post> findById(Long id);

	Post save(Post post);

	List<Post> findAll();
	
}