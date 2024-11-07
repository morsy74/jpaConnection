package com.example.jpademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jpademo.database.entity.Book;
import com.example.jpademo.database.repo.BookRepository;
import com.example.jpademo.service.exception.ResourceNotFoundException;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookById(Long id) {
		return bookRepository.findById(id)
		  .orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Book updateBook(Long id, Book newBook) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
      Book updatedBook = optionalBook.get();
      newBook.setId(updatedBook.getId());
      return bookRepository.save(newBook);
    }
		else{
			throw new ResourceNotFoundException(id);
		}
	}

	public Book deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
      Book deletedBook = optionalBook.get();
      bookRepository.deleteById(id);
			return deletedBook;
      
    }
		else{
			throw new ResourceNotFoundException(id);
		}
	}
}