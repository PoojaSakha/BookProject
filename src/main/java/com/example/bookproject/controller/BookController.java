package com.example.bookproject.controller;

import com.example.bookproject.entity.Book;
import com.example.bookproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
        @Autowired
        private BookService bookService;

        @GetMapping
        public List<Book> getAllBooks() {
            return bookService.getAllBooks();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Book> getBookById(@PathVariable Long id) {
            Optional<Book> book = bookService.getBookById(id);
            return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public Book createBook(@RequestBody Book book) {
            return bookService.saveBook(book);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
            Optional<Book> book = bookService.getBookById(id);
            if (book.isPresent()) {
                Book updatedBook = book.get();
                updatedBook.setTitle(bookDetails.getTitle());
                updatedBook.setAuthor(bookDetails.getAuthor());
                return ResponseEntity.ok(bookService.saveBook(updatedBook));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        }
    }


