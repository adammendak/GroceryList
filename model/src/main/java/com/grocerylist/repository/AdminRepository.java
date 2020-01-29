package com.grocerylist.repository;

import com.grocerylist.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-20
 * This interface is a description of the actions that admin can do
 * @extends JpaRepository
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
