package com.example.ecommerce.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.model.Book;

public interface BookService {
	List<Book> getAll();

	void createBook(Book book);

	void updateBook(Book book);

	Book deleteBook(long id);
	
	void uploadImage(MultipartFile file) throws IOException;
}
