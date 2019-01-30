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
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("books", bookRepository.findAll());
		return mv;
	}
	
//	@GetMapping(value= "/")
//	public String index(Book book) {
//		return "index";
//	}
	
//	@PostMapping("/")
//	public ModelAndView createBook(Book book) {
//		ModelAndView mv = new ModelAndView("page1");
//		Book newBook = bookRepository.save(new Book(book.getTitle(), book.getAuthor()));
//		mv.addObject("newBook", newBook);
//		return mv;
//	}
	
//	@PostMapping(value = "/page1")
//	public String addNewBook(Book book, Model model) {
//		bookRepository.save(new Book(book.getTitle(), 
//									 book.getAuthor()));
//		model.addAttribute("title", book.getTitle());
//		model.addAttribute("author", book.getAuthor());
//		return "results";
//	}



}
