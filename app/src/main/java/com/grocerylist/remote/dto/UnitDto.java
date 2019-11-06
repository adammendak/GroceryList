package com.grocerylist.remote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnitDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
//    BAG("Bag"),
//    BAR("Bar"),
//    BUNCH("Bunch"),
//    CAN("Can"),
//    CANE("Cane"),
//    CLOVE("Clove"),
//    COB("Cob"),
//    CUBE("Cube"),
//    CUP("Cup"),
//    GRAIN("Grain"),
//    HANDFUL("Handful"),
//    JAR("Jar"),
//    KG("Kg"),
//    L("L"),
//    LEAF("Leaf"),
//    LEAVES("Leaves"),
//    ML("Ml"),
//    PACKAGE("Package"),
//    PIECE("Piece"),
//    PINCH("Pinch"),
//    SLICE("Slice"),
//    SPRING("Spring"),
//    TABLESPOON("Tablespoon"),
//    TEASPOON("Teaspoon");
}
