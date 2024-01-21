package com.example.memorydb.book.service;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.db.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create, Update
    public BookEntity create(BookEntity book) {
        return bookRepository.save(book);
    }

    // Read (all)
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    // Read (one)


    // Delete

}
