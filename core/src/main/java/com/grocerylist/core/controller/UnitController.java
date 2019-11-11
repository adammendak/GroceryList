package com.grocerylist.core.controller;

import com.grocerylist.constants.Unit;
import com.grocerylist.mapper.UnitMapper;
//import com.grocerylist.model.Unit;
import com.grocerylist.dto.UnitDto;
//import com.grocerylist.dto.UnitMapper;
//import com.grocerylist.usecase.ProcessUnitUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequestMapping(value="/api/v1")
@RestController
public class UnitController {


    //TODO remove constructor, use @AllArgsConstructor from Lombok
    //TODO remove ProcessUnitUseCase

    private UnitMapper unitMapper;
//    private ProcessUnitUseCase processUnitUseCase;

//    public UnitController(UnitMapper unitMapper) {
//        this.unitMapper = unitMapper;
//        this.processUnitUseCase = processUnitUseCase;
//    }

//    @PostMapping("/add-unit")
//    public ResponseEntity addUnit(@RequestBody UnitDto unitDto) {
//        if (Objects.isNull(unitDto.getValue())) {
//
//            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);
//        }
//        Unit unit = unitMapper.mapToUnit(unitDto);
////        processUnitUseCase.addUnit(unit);
//        return null;

//    }

    @DeleteMapping("/remove-unit")
    public ResponseEntity<String> removeUnit(@RequestParam Long id) {
        if (Objects.isNull(id)) {

            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);
        }
        boolean isRemoved = true; //processUnitUseCase.removeUnit(id);
        return isRemoved ? new ResponseEntity("Your Unit was removed", HttpStatus.CREATED) :
                new ResponseEntity("Something goes wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

