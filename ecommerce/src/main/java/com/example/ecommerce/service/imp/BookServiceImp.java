package com.example.ecommerce.service.imp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.model.Book;
import com.example.ecommerce.repository.BookRepository;
import com.example.ecommerce.service.BookService;

@Service
public class BookServiceImp implements BookService{
	private BookRepository bookRepository;
	private byte[] bytes;
	@Autowired
	public BookServiceImp(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAll() {
		
		return bookRepository.findAll();
	}

	@Override
	public void createBook(Book book) {
		book.setPicByte(this.bytes);
		bookRepository.save(book);
		this.bytes=null;
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
		
	}

	@Override
	public Book deleteBook(long id) {
		Book book = bookRepository.getById(id);
		bookRepository.deleteById(id);
		return book;
	}

	@Override
	public void uploadImage(MultipartFile file) throws IOException {
		this.bytes = file.getBytes();		
	}
	
}
