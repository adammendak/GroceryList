import { Component } from '@angular/core';
import { Dish } from "../model/dish";
import { DishService } from "../service/dish.service";
import { Router } from "@angular/router";
import { UserAuthService } from "../service/user-auth.service";
import { DishCategory } from "../model/dishCategory";
import { MyListService } from "../service/my-list.service";

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html'
})
export class DishComponent {

  _listFilter: string;

  filteredDishes: Dish[];
  dishes: Dish[] = [];

  categories: DishCategory[];

  constructor(public _auth: UserAuthService,
              public _dish: DishService,
              private _router: Router,
              private _myList: MyListService) {
    this.getLocalDishCategories();
  }

  adjustFilter(filter: string) {
     this.filteredDishes = this.dishes.filter(name =>
       name.description.toLocaleLowerCase()
         .startsWith(filter.toLocaleLowerCase()))
  }

  goToAddDish() {
    this._router.navigate(['/addDish']).catch();
  }

  goToAddDishCategory() {
    this._router.navigate(['/addDishCategory']).catch();
  }

  deleteDish(id: number) {
    this._dish.deleteDish(id);
    this._router.navigate(['/welcome']).catch();
  }

  editCategory(id: number) {
    this._router.navigate(['/editDishCategory/' + id]).catch();
  }

  deleteCategory(id: number) {
    this._dish.deleteDishCategory(id);
    this._router.navigate(['/welcome']).catch();
  }

  private getLocalDishCategories() {
    this._dish.getDishCategories().subscribe(
      (data) => {
        this.categories = data;
        this.getDishesForCategory(this.categories[0].name);
      });
  }

  getDishesForCategory(name :string) {
    this._dish.getDishesForCategory(name).subscribe(
      (data) => {
        this.dishes = data;
        this.filteredDishes = data;
      }
    )
  }

  getDishesForCategoryEvent(id) {
    this._dish.getDishesForCategory(id.target.value).subscribe(
      (data) => {
        this.dishes = data;
        this.filteredDishes = data;
      }
    )
  }

  addThisToMyList(dish: Dish) {
    this._myList.addDish(dish);
  }

}
