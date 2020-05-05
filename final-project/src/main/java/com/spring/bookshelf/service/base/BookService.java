package com.spring.bookshelf.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.spring.bookshelf.model.Book;
import com.spring.bookshelf.repository.BookRepository;


@Component
public interface BookService {
	
	
	public Book findByBookId(Long id);
	public Book saveBook(Book book); 
	public List<Book> searchBook(String bookName); 
	public List<Book> getAllBookList();
	
	
	
	

	
}
