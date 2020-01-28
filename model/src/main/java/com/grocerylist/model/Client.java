package com.grocerylist.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-19
 *
 * Abstract class which contains fields for holding entered Client data
 */
@Data
@Entity
@Table(name = "CLIENT")
public class Client extends User {

}
