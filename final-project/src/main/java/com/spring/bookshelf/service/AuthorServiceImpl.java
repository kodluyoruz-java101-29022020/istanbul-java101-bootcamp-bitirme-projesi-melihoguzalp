package com.spring.bookshelf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bookshelf.annotation.MethodRunningTime;
import com.spring.bookshelf.model.Author;
import com.spring.bookshelf.repository.AuthorRepository;
import com.spring.bookshelf.service.base.AuthorService;


@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	
	
	@MethodRunningTime(active = false)
	@Override
	public Author findByAuthorId(Long id) {

		return authorRepository.findWithAuthorId(id);
		
	} 
	
	
	
	@Override
	@Transactional 
	public Author saveAuthor(Author author) {// add author using saveAuthor
		
			return authorRepository.save(author);

	}




	@MethodRunningTime(active = true)
	@Override
	public List<Author> getAllAuthorList() {
		
		return authorRepository.getAllAuthorList();
	
	}



	

}
