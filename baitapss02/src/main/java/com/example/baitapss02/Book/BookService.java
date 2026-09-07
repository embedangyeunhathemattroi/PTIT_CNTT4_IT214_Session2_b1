package com.example.baitapss02.Book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Book not found: " + id));
    }
}