package com.grocerylist.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    public String value;


}
