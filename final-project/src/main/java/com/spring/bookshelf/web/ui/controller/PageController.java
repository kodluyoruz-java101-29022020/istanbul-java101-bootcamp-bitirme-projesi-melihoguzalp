package com.spring.bookshelf.web.ui.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.bookshelf.model.Author;
import com.spring.bookshelf.model.Book;
import com.spring.bookshelf.service.base.AuthorService;
import com.spring.bookshelf.service.base.BookService;



@Controller
public class PageController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getBooks(Model model) {
		
		List<Book> books = bookService.getAllBookList();
		model.addAttribute("books", books);
		
		

		return "pages/thyme_book_list";
	}
	
	
	@RequestMapping(value = "/book/save", method = RequestMethod.GET)
	public String getBookSavePage(Book book, Model model) {
		
		List<Author> authors = authorService.getAllAuthorList();
		model.addAttribute("authors", authors);

		
		return "pages/thyme_book_save";
	}
	
	
	@RequestMapping(value = "/book/list", method = RequestMethod.POST)
    public String save(Book book, BindingResult result, Model model) {
        
		
		
		bookService.saveBook(book);
		model.addAttribute("books", bookService.getAllBookList());

        
        return "pages/thyme_book_list";
    }
	
	@RequestMapping(value = "/book/search", method = RequestMethod.GET)
	public String getBookSearchPage(String bookName, Model model) {
		
		List<Book> books = bookService.searchBook(bookName);
		model.addAttribute("books", books);

		
		return "pages/thyme_book_list";
	}
	
	
}
