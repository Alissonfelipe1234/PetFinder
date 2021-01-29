package br.edu.ifsp.petFinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.petFinder.model.Post;
import br.edu.ifsp.petFinder.repository.PostRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PostController {
	  @Autowired
	  PostRepository postRepository;
	
	  @GetMapping("/posts")
	  public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String nome) {
		return null;
	  }
	
	  @GetMapping("/posts/{id}")
	  public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
		return null;
	    
	  }
	  
	  @PostMapping("/posts")
	  public ResponseEntity<Post> createPost(@RequestBody Post post) {
		return null;
	    
	  }
	
	  @PutMapping("/posts/{id}")
	  public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post) {
		return null;
		  
	  }
	
	  @DeleteMapping("/posts/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
		return null;
	   	
	  }
	
	  @DeleteMapping("/posts")
	  public ResponseEntity<HttpStatus> deleteAllPosts() {
		return null;
	    	
	  }
	
	  @GetMapping("/posts/published")
	  public ResponseEntity<List<Post>> findByPublished() {
		return null;
	    	
	  }
}
