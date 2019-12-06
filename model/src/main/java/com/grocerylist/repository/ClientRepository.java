package com.grocerylist.repository;

import com.grocerylist.model.Client;
import com.grocerylist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    User findByUserName(String userName);
    User findByEmail(String email);
}
