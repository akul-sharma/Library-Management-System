package com.assignment9.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment9.model.User;


public interface UserRepo extends JpaRepository<User,Integer>{

}
