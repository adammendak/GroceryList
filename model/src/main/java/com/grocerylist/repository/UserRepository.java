package com.grocerylist.repository;


import com.grocerylist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * @author  Elżbieta Dutkiewicz
 * @version 1.0
 * @since   2019-01-15

 * This interface consists exclusively of method which used for data transmission in UserService.class from core module
 * This interface is a description of the actions that user can do
 * @return User type of optional
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

}
