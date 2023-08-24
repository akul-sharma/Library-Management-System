package com.assignment9.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment9.model.Authors;


public interface AuthorsRepo extends JpaRepository<Authors,Integer>{

}
