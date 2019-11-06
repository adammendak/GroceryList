package com.grocerylist.remote.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ProductDto {
    private Long id;
    private String name;
    private List<UnitDto> unitDtoList;
}
