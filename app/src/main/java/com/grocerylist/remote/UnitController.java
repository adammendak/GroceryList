package com.grocerylist.remote;

import com.grocerylist.model.Dish;
import com.grocerylist.model.Unit;
import com.grocerylist.remote.dto.UnitDto;
import com.grocerylist.remote.dto.UnitMapper;
import com.grocerylist.usecase.ProcessUnitUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value="/api/v1")
@RestController
public class UnitController {

    //TODO move to core/controller module
    //TODO remove constructor, use @AllArgsConstructor from Lombok
    //TODO remove ProcessUnitUseCase

    private UnitMapper unitMapper;
    private ProcessUnitUseCase processUnitUseCase;

    public UnitController(UnitMapper unitMapper, ProcessUnitUseCase processUnitUseCase) {
        this.unitMapper = unitMapper;
        this.processUnitUseCase = processUnitUseCase;
    }

    @PostMapping("/add-unit")
    public ResponseEntity<String> addUnit(@RequestBody UnitDto unitDto) {
        if (Objects.isNull(unitDto.getName())) {

            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);
        }
        Unit unit = unitMapper.mapToUnit(unitDto);
        processUnitUseCase.addUnit(unit);
        return null;

    }

    @DeleteMapping("/remove-unit")
    public ResponseEntity<String> removeUnit(@RequestParam Long id) {
        if (Objects.isNull(id)) {

            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);
        }
        boolean isRemoved = processUnitUseCase.removeUnit(id);
        return isRemoved ? new ResponseEntity("Your Unit was removed", HttpStatus.CREATED) :
                new ResponseEntity("Something goes wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

