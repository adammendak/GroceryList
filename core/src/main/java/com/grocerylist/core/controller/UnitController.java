package com.grocerylist.core.controller;

import com.grocerylist.constants.Unit;
import com.grocerylist.dto.UnitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unit")
@RequiredArgsConstructor
public class UnitController {

    @GetMapping()
    public ResponseEntity getAllUnits() {
        UnitDto dto = UnitDto.builder()
                .unitNames(Unit.getAllUnits())
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dto);
    }
}
