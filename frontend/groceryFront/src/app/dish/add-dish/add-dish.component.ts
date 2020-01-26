import { Component } from '@angular/core';
import { DishService } from "../../service/dish.service";
import { Router } from "@angular/router";
import { DishCategory } from "../../model/dishCategory";
import { Dish } from "../../model/dish";
import { ProductService } from "../../service/product.service";
import { Ingredient } from "../../model/ingredient";
import { Product } from "../../model/product";

@Component({
  selector: 'app-add-dish',
  templateUrl: './add-dish.component.html'
})
export class AddDishComponent {

  categories: DishCategory[];
  categorySelected: string;
  ingredients : Ingredient[] = [];
  products: Product[];
  newProduct: string;
  newIngredientQuantity: number;

  constructor(public _dish: DishService,
              private _router: Router,
              private _productService: ProductService) {
    this.getDishCategories();
    this.getProducts();
  }

  private getDishCategories() {
    this._dish.getDishCategories().subscribe(
      (data) => {
        this.categories = data;
        this.categorySelected = this.categories[0].name;
      })
  }

  private getProducts() {
    this._productService.getProducts().subscribe(
      (data) => {
        this.products = data;
        this.newProduct = this.products[0].name;
      })
  }

  addDish(dishForm) {
    let resultDish = new Dish();
    let dishCategory = new DishCategory();
    dishCategory.setName(this.categorySelected);
    let dishCategories: DishCategory[] = [dishCategory];

    resultDish.setDescription(dishForm.value.description);
    resultDish.setPrepareTime(dishForm.value.prepareTime);
    resultDish.setDifficultyLevel(dishForm.value.difficultyLevel);
    resultDish.setNumberOfServings(dishForm.value.numberOfServings);
    resultDish.setCategories(dishCategories);
    resultDish.setIngredients(this.ingredients);
    this._dish.addDish(resultDish);
  }

  setDishCategory(category) {
    this.categorySelected = category.target.value;
  }

  isSelected(name:string) {
    return name === this.categorySelected;
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
