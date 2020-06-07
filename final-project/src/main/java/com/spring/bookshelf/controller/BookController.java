package com.spring.bookshelf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bookshelf.model.Book;
import com.spring.bookshelf.service.BookServiceImpl;
import com.spring.bookshelf.service.base.BookService;


@RestController			
@RequestMapping("/library")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/book/{id}")
	@ResponseBody
	public Book findByBookId(@PathVariable("id") Long id){
		
		return bookService.findByBookId(id);
			
	}
	
	@GetMapping("/book/list")
	@ResponseBody
	public List<Book> getAllBookList(){
		
		return bookService.getAllBookList();
			
	}
	
	@PostMapping("/book")
    @ResponseBody  
	public Book save(@RequestBody Book book) {//add book
		
		return bookService.saveBook(book);
	} 
	
	@PutMapping("/book/update")
    @ResponseBody  
	public Book update(@RequestBody Book book) {//update book
		
		return bookService.update(book);
	} 
	


	@DeleteMapping("/book/delete/{bookId}")
	public void deleteBook(@PathVariable Long bookId) {
		bookService.delete(bookId);
	}
}
