package com.spring.bookshelf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.bookshelf.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {

	@Query(value = "FROM Author a WHERE a.id = :id")
	public Author findWithAuthorId(@Param("id") Long id);
	
	

	@Query(value = "SELECT a FROM Author a")
	public List<Author> getAllAuthorList();
	
	

	@Query("SELECT a FROM Author a WHERE a.name LIKE %:name%")
	public List<Author> findByAuthorName(@Param("name") String name);
	
	
}
