package com.spring.bookshelf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bookshelf.annotation.MethodRunningTime;
import com.spring.bookshelf.model.Book;
import com.spring.bookshelf.repository.BookRepository;
import com.spring.bookshelf.service.base.BookService;

@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	private BookRepository bookRepository;
	
	
	
	
	@MethodRunningTime(active = false)
	@Override
	public Book findByBookId(Long id) {

		return bookRepository.findWithBookId(id);
	}

	
	
	@Override
	@Transactional  
	public Book saveBook(Book book) {// add book using saveBook
				
		return bookRepository.save(book);
		 

	}


	@MethodRunningTime(active = true)
	@Override
	public List<Book> getAllBookList() {
		
		return bookRepository.getAllBookList();
	}



	@Override
	public List<Book> searchBook(String bookName) {

		
			return bookRepository.findByBookName(bookName);

		
	}



	@Override
	public Book update(Book book) {

		
		return bookRepository.save(book);
	} 



	@Override
	public void delete(Long bookId) {

		
		if(bookRepository.findById(bookId) != null) {
			
			
			bookRepository.deleteById(bookId);

		}
		
		
	}



}
