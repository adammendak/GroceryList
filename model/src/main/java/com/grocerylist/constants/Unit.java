package com.grocerylist.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<String> getAllUnits() {
        return Arrays.stream(Unit.values())
                .map(Unit::getValue)
                .collect(Collectors.toList());
    }

}
