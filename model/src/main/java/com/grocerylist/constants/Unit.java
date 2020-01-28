package com.grocerylist.constants;

import com.grocerylist.dto.UnitDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-19
 *
 * This class contains units that can be used in database
 * Contains method to call List of all units
 *
 */
@AllArgsConstructor
@Getter
public enum Unit {
    BAG("Bag"),
    BAR("Bar"),
    BUNCH("Bunch"),
    CAN("Can"),
    CANE("Cane"),
    CLOVE("Clove"),
    COB("Cob"),
    CUBE("Cube"),
    CUP("Cup"),
    GRAIN("Grain"),
    HANDFUL("Handful"),
    JAR("Jar"),
    KG("Kg"),
    L("L"),
    LEAF("Leaf"),
    LEAVES("Leaves"),
    ML("Ml"),
    PACKAGE("Package"),
    PIECE("Piece"),
    PINCH("Pinch"),
    SLICE("Slice"),
    SPRING("Spring"),
    TABLESPOON("Tablespoon"),
    TEASPOON("Teaspoon");

    private String value;

    public static List<UnitDto> getAllUnits() {
        return Arrays.stream(Unit.values())
                .map(UnitDto::new)
                .collect(Collectors.toList());
    }

}
