package com.example.baitapss02.Book;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepository {

    private final Map<Long, Book> books = new ConcurrentHashMap<>(
            Map.of(
                    1L, new Book(1L, "Clean Code", "Robert C. Martin"),
                    2L, new Book(2L, "Domain-Driven Design", "Eric Evans")
            )
    );

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }
}