package com.grocerylist.dao.repository;

import com.grocerylist.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
