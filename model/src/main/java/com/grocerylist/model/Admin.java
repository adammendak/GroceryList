package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ADMIN")
public class Admin extends User {

}
