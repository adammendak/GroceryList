package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @NotNull
    @NotEmpty
    private String name;

    @JsonProperty("unit")
    @NotNull
    private String unit;

    @JsonProperty("productCategory")
    @NotNull
    private ProductCategoryDto productCategory;

}
