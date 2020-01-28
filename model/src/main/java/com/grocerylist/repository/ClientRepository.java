package com.grocerylist.repository;

import com.grocerylist.model.Client;
import com.grocerylist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2020-01-19
 *  This interface is a description of the actions that client can do
 *  @extends JpaRepository
 * This interface consists exclusively of methods used for data transmission in ClientService.class from core module,
 * which @returns Client type of objects and lists
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    User findByUserName(String userName);

    User findByEmail(String email);

    Optional<Client> findById(Long id);

    Optional<Client> findByUserNameAndPassword(String userName, String password);

    List<Client> findAll();
}
