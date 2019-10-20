package com.grocerylist.dao.repository;

import com.grocerylist.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
