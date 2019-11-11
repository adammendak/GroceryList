package com.grocerylist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

@Data
@Entity
@Table(name = "LOGIN")
public class LoginData {

        @Column(name = "USER_NAME")
        private String userName;

        @Column(name = "HASH_PASSWORD")
        private String HashPassword;

        @Column(name = "DIFFICULTY_LEVEL")
        private String retriedPassword;


}
