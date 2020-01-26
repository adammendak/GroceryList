import { Injectable } from '@angular/core';
import {Dish} from "../model/dish";

@Injectable({
  providedIn: 'root'
})
export class MyListService {

  public myList: Dish[] = [];
  public numberOfDishes: number = 0;

  constructor() { }

  public addDish(dish: Dish) {
    this.myList.push(dish);
    this.numberOfDishes = this.myList.length;
  }
}
