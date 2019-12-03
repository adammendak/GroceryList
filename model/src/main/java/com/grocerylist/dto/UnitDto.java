package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class UnitDto {

    @JsonProperty("unit_names")
    @NotNull
    private List<String> unitNames;
}
