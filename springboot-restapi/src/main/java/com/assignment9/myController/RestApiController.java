package com.assignment9.myController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment9.model.*;
import com.assignment9.repo.AuthorsRepo;
import com.assignment9.repo.BooksRepo;

@RestController
public class RestApiController {

	@Autowired
	BooksRepo booksRepo;
	
	
	@Autowired
	AuthorsRepo authorsRepo;
	
	@GetMapping("/books")
	public List<Books> getBooks() {
		return booksRepo.findAll();
	}
	
	@PostMapping("/books")
	public Books addBook(Books book) {
		booksRepo.save(book);
		return book;
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		boolean check=booksRepo.findById(bookId).isPresent();
		if(check==true) {
			Books book=booksRepo.getOne(bookId);
			booksRepo.delete(book);
			return "Deleted Successfully";
		}
		return "Record Not Found";
	}
	
	@PutMapping("/books")
	public String saveOrUpdateBook(Books book) {
		boolean check=authorsRepo.findById(book.getId()).isPresent();
		if(check==true) {
			booksRepo.save(book);
			return "Added Successfully";
		}
		else
			return "Record Not Found";
	}
	
	@GetMapping("/authors")
	public List<Authors> getAuthors() {
		return authorsRepo.findAll();
	}
	
	@PostMapping("/authors")
	public Authors addAuthor(Authors author) {
		authorsRepo.save(author);
		return author;
	}
	
	@DeleteMapping("/authors/{authorId}")
	public String deleteAuthor(@PathVariable int authorId) {
		boolean check=authorsRepo.findById(authorId).isPresent();
		if(check==true) {
			Authors author=authorsRepo.getOne(authorId);
			authorsRepo.delete(author);
			return "Deleted Successfully";
		}
		return "Record Not Found";
	}
	
	@PutMapping("/authors")
	public String saveOrUpdateAuthor(Authors author) {
		boolean check=authorsRepo.findById(author.getAuthorId()).isPresent();
		if(check==true) {
			authorsRepo.save(author);
			return "Added Successfully";
		}
		else
			return "Record Not Found";
	}
	
}
