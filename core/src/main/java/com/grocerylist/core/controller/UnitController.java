package com.grocerylist.core.controller;

import com.grocerylist.constants.Unit;
import com.grocerylist.core.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-12-03
 *
 * This class contains methods for manage units database
 */
@RestController
@RequestMapping("/api/unit")
@RequiredArgsConstructor
public class UnitController {
    /**
     * getAllUnits() method accepts the request for GET
     *
     * @return productCategory
     * @return ResponseEntity
     */
    @GetMapping()
    public ResponseEntity getAllUnits() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Unit.getAllUnits());
    }
}
