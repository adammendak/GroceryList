import { Component } from '@angular/core';
import { Dish } from "../model/dish";
import { DishService } from "../service/dish.service";
import {Router} from "@angular/router";
import {UserAuthService} from "../service/user-auth.service";

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html'
})
export class DishComponent {

  _listFilter: string;

  filteredDishes: Dish[];
  dishes: Dish[] = [];

  constructor(public _auth: UserAuthService,
              public _dish: DishService,
              private _router: Router,) {
    this._dish.getDishes().subscribe(
      (data) => {
        this.dishes = data;
        this.filteredDishes = data;
        console.log(this.dishes);
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

}
