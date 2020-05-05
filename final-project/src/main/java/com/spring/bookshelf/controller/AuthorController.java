package com.spring.bookshelf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bookshelf.model.Author;
import com.spring.bookshelf.service.base.AuthorService;


@RestController			
@RequestMapping("/library")
public class AuthorController {

	
	
	@Autowired
	private AuthorService authorService;
	
	
	
	@GetMapping("/author/{id}")
	@ResponseBody
	public Author findByAuthorId(@PathVariable("id") Long id){
		
		return authorService.findByAuthorId(id);
			
	}
	
	@GetMapping("/author/list")
	@ResponseBody
	public List<Author> getAllAuthorList(){
		
		return authorService.getAllAuthorList();
			
	}
	
	@PostMapping("/author")  
    @ResponseBody
	public Author save(@RequestBody Author author) {// add author
		
		return authorService.saveAuthor(author);
	} 
	
	
	
	
	
	
}
