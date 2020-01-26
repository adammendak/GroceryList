import { Component } from '@angular/core';
import { Dish } from "../model/dish";
import { MyListService } from "../service/my-list.service";
import { DishService } from "../service/dish.service";
import { DishCategory } from "../model/dishCategory";
import {Ingredient} from "../model/ingredient";

@Component({
  selector: 'app-mylist',
  templateUrl: './mylist.component.html'
})
export class MylistComponent {

  pageTitle: string = "My Grocery List";
  _listFilter: string;

  dishes: Dish[] = [];
  categories: DishCategory[];
  ingredients: Ingredient[] = [];

  constructor(private listService: MyListService,
              private _dishesService: DishService) {
    this.dishes = listService.myList;
    this._dishesService.getDishCategories().subscribe(
      (data) => {
        this.categories = data;
      });
    this.extractIngredient();
  }

  private extractIngredient() {
    this.ingredients = [];
    this.dishes.forEach(p => {
      p.ingredients.forEach(x => this.ingredients.push(x))
    })
  }

  deleteDish(dish: Dish) {
    this.listService.myList = this.listService.myList.filter(p => p!== dish);
    this.listService.numberOfDishes = this.listService.myList.length;
    this.dishes = this.listService.myList;
    this.extractIngredient();
  }

}
