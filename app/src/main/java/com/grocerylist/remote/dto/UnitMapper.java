package com.grocerylist.remote.dto;

import com.grocerylist.model.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitMapper {
    //TODO move to MODEL/mapper module
    public Unit mapToUnit (UnitDto unitDto) {
        Unit unit = new Unit();
        unit.setId(unitDto.getId());
        unit.setName(unitDto.getName());
        return unit;
    }
}
