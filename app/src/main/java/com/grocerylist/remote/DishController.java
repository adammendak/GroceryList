package com.grocerylist.remote;

import com.grocerylist.model.Dish;
import com.grocerylist.remote.dto.DishDto;
import com.grocerylist.remote.dto.DishMapper;
import com.grocerylist.remote.dto.DishSpecifyRequestDto;
import com.grocerylist.usecase.GetDishesUseCase;
import com.grocerylist.usecase.ProcessDishUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1", produces = APPLICATION_JSON_VALUE)
@RestController
public class DishController {
    private DishMapper dishMapper;
    private ProcessDishUseCase processDishUseCase;
    private GetDishesUseCase getDishesUseCase;

    public DishController(DishMapper dishMapper, ProcessDishUseCase processDishUseCase, GetDishesUseCase getDishesUseCase) {
        this.dishMapper = dishMapper;
        this.processDishUseCase = processDishUseCase;
        this.getDishesUseCase = getDishesUseCase;
    }

    @PostMapping("/add-dish")
    public ResponseEntity<String> addDish(@RequestBody DishDto dishDto) {
        if (dishDto.getIngredients().isEmpty()
                || dishDto.getCategoriesList().isEmpty()
                || Objects.isNull(dishDto.getDifficultyLevel())
                || Objects.isNull(dishDto.getRecipe())) {
            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);
        }
        Dish dish = dishMapper.mapToDish(dishDto);
        processDishUseCase.run(dish);
        return null;
        //TODO: implement service insert record to DataBase
    }

    @GetMapping("/get-dishes")
    public ResponseEntity<List<DishDto>> getDishes(@RequestBody DishSpecifyRequestDto dishSpecifyRequestDto) {
        getDishesUseCase.getDishes(dishSpecifyRequestDto.getCategoriesList(), dishSpecifyRequestDto.getDifficultyLevel());
        return null;


    }

}


