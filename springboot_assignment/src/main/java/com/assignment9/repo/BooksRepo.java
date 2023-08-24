package com.assignment9.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.assignment9.model.Books;

public interface BooksRepo extends JpaRepository<Books,Integer>{

}
