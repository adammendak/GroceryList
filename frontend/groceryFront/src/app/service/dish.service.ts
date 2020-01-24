import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { Dish } from "../model/dish";
import {Observable} from "rxjs";
import {applicationProperties} from "../properties";
import {DishCategory} from "../model/dishCategory";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class DishService {

  dishes: Dish[];
  urlDish = applicationProperties.dishApi;
  urlDishCategory = applicationProperties.dishCategoryApi;

  constructor(private http: HttpClient,
              private _router: Router,
              private toastr: ToastrService) {
  }

  getDishes(): Observable<Dish[]> {
    return this.http.get<Dish[]>(this.urlDish);
  }

  getDishCategories(): Observable<DishCategory[]> {
    return this.http.get<DishCategory[]>(this.urlDishCategory);
  }

  addDish(dish: Dish) {
    this.http.post(this.urlDish, dish).subscribe(
      (data) => {
        this._router.navigate(['/dish']).catch();
        this.showCreated('DISH ADDED!');
      }, error => {
        this.showError('ERROR ADDING DISH');
      }
    );
  }

  deleteDish(id: number) {
    this.http.delete(this.urlDish + '/' + id).subscribe(
      (data) => {
        this._router.navigate(['/dish']).catch();
        this.showError('DISH DELETED!');
      }, error => {
        this.showError('DISH DELETED!');
        this._router.navigate(['/welcome']).catch();
      });
  }

  showCreated(text: string) {
    this.toastr.success( text);
  }

  showError(text: string) {
    this.toastr.error(text);
  }

}
