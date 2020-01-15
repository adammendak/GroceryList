package com.grocerylist.repository;

import com.grocerylist.model.Client;
import com.grocerylist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
}