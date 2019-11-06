package com.grocerylist.remote.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ProductDto {
    //TODO move to MODEL/dto module
    private Long id;
    private String name;
    private List<UnitDto> unitDtoList;
}
