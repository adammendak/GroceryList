import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { DishService } from "../../service/dish.service";
import { Dish } from "../../model/dish";
import { DishCategory } from "../../model/dishCategory";
import { Ingredient } from "../../model/ingredient";
import { Product } from "../../model/product";
import { ProductService } from "../../service/product.service";

@Component({
  selector: 'app-edit-dish',
  templateUrl: './edit-dish.component.html'
})
export class EditDishComponent implements OnInit {

  dish: Dish;
  categories: DishCategory[];
  categorySelected: string;
  id: number;
  ingredients: Ingredient[];

  newProduct: string;
  newIngredientQuantity: number;
  products: Product[];


  constructor(private _route: ActivatedRoute,
              private _dishService: DishService,
              private _router: Router,
              private _productService: ProductService) { }

  ngOnInit(): void {
    this.getDishCategories();
    this.getDish();
    this.getProducts();
  }

  editDish(dishForm) {
    let resultDish = new Dish();
    let dishCategory = new DishCategory();
    dishCategory.setName(this.categorySelected);
    let dishCategories: DishCategory[] = [dishCategory];

    resultDish.setId(this.id);
    resultDish.setDescription(dishForm.value.description);
    resultDish.setPrepareTime(dishForm.value.prepareTime);
    resultDish.setDifficultyLevel(dishForm.value.difficultyLevel);
    resultDish.setNumberOfServings(dishForm.value.numberOfServings);
    resultDish.setCategories(dishCategories);
    resultDish.setIngredients(this.ingredients);
    this._dishService.editDish(resultDish);
  }

  isSelectedCategory(name:string) {
    return name === this.categorySelected;
  }

  setDishCategory(category) {
    this.categorySelected = category.target.value;
  }

  private getDish() {
    this._dishService.getDish(this._route.snapshot.params['id'])
      .subscribe((data) => {
        this.dish = data;
        this.categorySelected = this.dish.categories[0].name;
        this.id = this.dish.id;
        this.ingredients = this.dish.ingredients;
      });
  }

  private getDishCategories() {
    this._dishService.getDishCategories().subscribe(
      (data) => {
        this.categories = data;
      })
  }

  private getProducts() {
    this._productService.getProducts().subscribe(
      (data) => {
        this.products = data;
        this.newProduct = this.products[0].name;
      })
  }

  cancel(): void {
    this._router.navigate(['/dish']).catch();
  }

  addNewIngredientToList() {
    let ingredient = new Ingredient();
    let prd = this.products.filter(p => p.name === this.newProduct)[0];
    ingredient.setQuantity(this.newIngredientQuantity);
    ingredient.setProduct(prd);
    this.ingredients.push(ingredient);
    this.newIngredientQuantity = null;
  }

  setNewIngredientProduct(ingredientName) {
    this.newProduct = ingredientName.target.value;
  }

  deleteIngredient(ingredient: Ingredient) {
    this.ingredients = this.ingredients.filter(p => p !== ingredient);
  }

}
