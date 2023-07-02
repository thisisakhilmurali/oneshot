package com.example.bookmonolith.controller;

import com.example.bookmonolith.model.Book;
import com.example.bookmonolith.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addbook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        if(bookList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(bookList);
        }
    }

    @GetMapping("/getbyid/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Optional<Book> optionalBook = bookRepository.findById(book.getBookId());
        if(optionalBook.isPresent()) {
            Book newBook = optionalBook.get();

            newBook.setBookId(book.getBookId());
            newBook.setBookName(book.getBookName());
            newBook.setPrice(book.getPrice());

            return ResponseEntity.ok(bookRepository.save(newBook));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()) {
            bookRepository.delete(book.get());
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.noContent().build();
        }
    }



}
