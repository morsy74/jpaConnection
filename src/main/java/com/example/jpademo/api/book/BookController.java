package com.example.jpademo.api.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpademo.database.entity.Book;
import com.example.jpademo.service.BookService;

@RestController
@RequestMapping("/api/books")

public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/allBooks")
  public ResponseEntity<?> getAllBooks() {
    return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .body(bookService.getAllBooks());
  }

  @PostMapping("/addBook")
  public ResponseEntity<?> addBook(@RequestBody Book book) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(bookService.addBook(book));
  }

  @GetMapping("/getBookById/{id}")
  public ResponseEntity<?> getBookById(@PathVariable Long id) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(bookService.getBookById(id));
  }

  @PutMapping("/updateBook/{id}")
  public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book book) {
    return ResponseEntity
        .status(HttpStatus.UPGRADE_REQUIRED)
        .body(bookService.updateBook(id, book));
  }

  @DeleteMapping("/deleteBook/{id}")
  public ResponseEntity<?> deleteBook(@PathVariable Long id) {
    return ResponseEntity
        .status(HttpStatus.UPGRADE_REQUIRED)
        .body(bookService.deleteBook(id));
  }
}
