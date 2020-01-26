import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { Dish } from "../model/dish";
import { Observable } from "rxjs";
import { applicationProperties } from "../properties";
import { DishCategory } from "../model/dishCategory";
import {ProductCategory} from "../model/productCategory";
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
        this._router.navigate(['/dish']).catch();
      }
    );
  }

  getDishCategory(id: number): Observable<DishCategory>{
    return this.http.get<DishCategory>(this.urlDishCategory+ '/' + id);
  }

  getDishesForCategory(name: string) {
    return this.http.get<Dish[]>(this.urlDish + '/getByName/' + name);
  }

  deleteDish(id: number) {
    this.http.delete(this.urlDish + '/' + id).subscribe(
      (data) => {
        this._router.navigate(['/dish']).catch();
        this.showError('DISH DELETED!');
      }, error => {
        this.showError('DISH DELETED!');
        this._router.navigate(['/dish']).catch();
      });
  }

  deleteDishCategory(id: number) {
    this.http.delete(this.urlDishCategory + '/' + id).subscribe(
      (data) => {
        this._router.navigate(['/dish']).catch();
        this.showError('DISH CATEGORY DELETED!');
      }, error => {
        this.showError('DISH CATEGORYDELETED!');
        this._router.navigate(['/dish']).catch();
      });
  }

  editDishCategory(name: string, id: number) {
    console.log(name + " " + id);
    let resultCategory = new DishCategory();
    resultCategory.setName(name);
    resultCategory.setId(id);
    this.http.put(this.urlDishCategory, resultCategory).subscribe(
      (data) => {
        this._router.navigate(['/dish']).catch();
        this.showCreated('DISH CATEGORY UPDATED!')
      },error => {
        this._router.navigate(['/dish']).catch();
      }
    );
  }

  addDishCategory(name: string) {
    let dishCategory = new DishCategory();
    let resultDishCategory;

    dishCategory.setName(name);

    this.http.post<DishCategory>(this.urlDishCategory , dishCategory).subscribe(
      (data) => {
        resultDishCategory = data;
        this.showCreated('Dish Category Created Successfully!');
        this._router.navigate(['/dish']).catch();
      },
      (error) => {
        this.showError('DISH CATEGORY CREATION FAILED');
        this._router.navigate(['/dish']).catch();
      }
    );
  }

  showCreated(text: string) {
    this.toastr.success( text);
  }

  showError(text: string) {
    this.toastr.error(text);
  }

}
