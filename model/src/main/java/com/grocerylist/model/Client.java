package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CLIENT")
public class Client extends User {

}
