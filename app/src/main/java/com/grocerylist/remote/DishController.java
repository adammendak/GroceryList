package com.grocerylist.remote;

public class DishController {

    //TODO move to core/controller module
    //TODO remove constructor, use @AllArgsConstructor from Lombok
    //TODO remove getDishesUseCase , use DishService from core/services

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
