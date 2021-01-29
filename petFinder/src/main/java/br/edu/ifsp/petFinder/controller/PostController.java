package br.edu.ifsp.petFinder.controller;

import java.util.List;
import java.util.Optional;

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
		  List<Post> results =  postRepository.findByNomeContaining(nome);
		  return new ResponseEntity<>(results, HttpStatus.OK);
	  }
	
	  @GetMapping("/posts/{id}")
	  public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
		  Optional<Post> result =  postRepository.findById(id);
		  if (result.isPresent()) {
			  Post post = result.get();
			  return new ResponseEntity<>(post, HttpStatus.OK);
		  }
		  return null;
	  }
	  
	  @PostMapping("/posts")
	  public ResponseEntity<Post> createPost(@RequestBody Post post) {
		  postRepository.saveAndFlush(post);
		  return new ResponseEntity<>(post, HttpStatus.OK);	    
	  }
	
	  @PutMapping("/posts/{id}")
	  public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post) {
		  postRepository.deleteById(id);
		  postRepository.saveAndFlush(post);
		  return new ResponseEntity<>(post, HttpStatus.OK);   
	  }
	
	  @DeleteMapping("/posts/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
		  postRepository.deleteById(id);
		  return new ResponseEntity<>(null, HttpStatus.OK); 
	  }
	
	  @DeleteMapping("/posts")
	  public ResponseEntity<HttpStatus> deleteAllPosts() {
		  postRepository.deleteAll();
		  return new ResponseEntity<>(null, HttpStatus.OK);
	  }
	
	  @GetMapping("/posts/published")
	  public ResponseEntity<List<Post>> findByPublished() {
		  List<Post> results =  postRepository.findByEncontrado(true);
		  return new ResponseEntity<>(results, HttpStatus.OK);
	  }
}
