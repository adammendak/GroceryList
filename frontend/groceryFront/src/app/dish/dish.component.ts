import { Component } from '@angular/core';
import { Dish } from "../model/dish";
import { DishService } from "../service/dish.service";
import {Router} from "@angular/router";
import {UserAuthService} from "../service/user-auth.service";
import {DishCategory} from "../model/dishCategory";

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
              private _router: Router) {
    this._dish.getDishes().subscribe(
      (data) => {
        this.dishes = data;
        this.filteredDishes = data;
      });
    this._dish.getDishCategories().subscribe(
      (data) => {
        this.categories = data;
      })
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

}
