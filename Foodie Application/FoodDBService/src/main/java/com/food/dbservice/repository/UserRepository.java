package com.food.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.dbservice.model.Quote;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUserName(String username);
}
