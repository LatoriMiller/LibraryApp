package com.techtalentsouth.library.book;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/")
	public ModelAndView index(Book book) {
		ModelAndView mv = new ModelAndView("/book/index");
		mv.addObject("books", bookRepository.findAll());
		return mv;
	}
	
	@GetMapping("/book/addBook")
	public ModelAndView showAddBook(Book book) {
		ModelAndView mv = new ModelAndView("book/addBook");
		//mv.addObject("books", bookRepository.findAll());
		return mv;
	}
	
	@PostMapping("/book/newBook")
	public ModelAndView createBook(Book book) {
		ModelAndView mv = new ModelAndView("book/index");
		Book newBook = bookRepository.save(new Book(book.getTitle(), book.getAuthor()));
		mv.addObject("newBook", newBook);
		mv.addObject("books", bookRepository.findAll());
		return mv;
	}
	




}
