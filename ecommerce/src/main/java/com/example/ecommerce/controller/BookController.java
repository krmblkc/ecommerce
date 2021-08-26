package com.example.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.model.Book;
import com.example.ecommerce.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/get")
	public List<Book> getBooks(){
		return bookService.getAll();
	}
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		bookService.uploadImage(file);
	}
	
	@PostMapping("/add")
	public void createBook(@RequestBody Book book) {
		bookService.createBook(book);
	}
	
	@PutMapping("/update")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public Book deleteBook(@PathVariable("id") long id) {
		return bookService.deleteBook(id);
	}
}
