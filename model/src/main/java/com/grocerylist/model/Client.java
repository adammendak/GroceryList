package com.grocerylist.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CLIENT")
public class Client extends User {

}
