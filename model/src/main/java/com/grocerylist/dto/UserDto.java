package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocerylist.constants.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
