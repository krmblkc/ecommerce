package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
