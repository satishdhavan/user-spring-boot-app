package com.example.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
}
