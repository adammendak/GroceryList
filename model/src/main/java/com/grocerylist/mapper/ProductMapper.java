package com.grocerylist.mapper;

//todo implement Mapstruct Mapper interface

import com.grocerylist.constants.Unit;
import com.grocerylist.dto.ProductDto;
import com.grocerylist.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private UnitMapper unitMapper;

    public ProductMapper(UnitMapper unitMapper) {
        this.unitMapper = unitMapper;
    }

    public Product mapToProduct(ProductDto productDto) {

        Product product = new Product();
//        List<Unit> units = productDto
//                .getUnitDtoList()
//                .stream()
//                .map(unitDto -> unitMapper.mapToUnit(unitDto))
//                .collect(Collectors.toList());

//        product.setUnits(units);
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        return product;

    }

}
