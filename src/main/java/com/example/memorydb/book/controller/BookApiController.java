package com.example.memorydb.book.controller;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookApiController {

    private final BookService bookService;

    @PutMapping("")
    public BookEntity create(
            @RequestBody BookEntity bookEntity
    ) {
        return bookService.create(bookEntity);
    }


    @GetMapping("all")
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }
}
