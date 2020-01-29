package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Adam Mendak
 * @version 1.0
 * @since 2019-11-14
 * This class contains data structure type (DTO) for User
 * It contains only field which are managed by service.class
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("userName")
    @NotNull
    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    @NotNull
    private String password;

}
