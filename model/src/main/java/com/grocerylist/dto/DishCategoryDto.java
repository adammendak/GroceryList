package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Adam Mendak
 * @version 1.0
 * @since 2019-10-20
 * This class contains data structure type (DTO) for DishCategory
 * It contains only field which are managed by service.class
 */
@Data
public class DishCategoryDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @NotNull
    @NotEmpty
    private String name;

}
