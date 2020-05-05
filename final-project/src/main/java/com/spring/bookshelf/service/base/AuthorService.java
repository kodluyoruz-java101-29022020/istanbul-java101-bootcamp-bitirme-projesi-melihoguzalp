package com.spring.bookshelf.service.base;

import java.util.List;

import org.springframework.stereotype.Component;
import com.spring.bookshelf.model.Author;
import com.spring.bookshelf.model.Book;

@Component
public interface AuthorService {
	
	public Author findByAuthorId(Long id);
	public Author saveAuthor(Author author);
	public List<Author> getAllAuthorList();
	
	

}
