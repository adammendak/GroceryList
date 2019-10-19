package com.grocerylist.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ADMIN")
public class Admin extends User {

}
