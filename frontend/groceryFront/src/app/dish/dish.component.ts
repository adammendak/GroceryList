import { Component, OnInit } from '@angular/core';
import { IDish } from "../model/dish";
import { IProduct } from "../model/product";

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html'
})
export class DishComponent {

  _listFilter: string;
  showImage: boolean = false;

  filteredDishes: IDish[];
  dishes: IDish[] = [];

  products: IProduct[] = [];

  imageWidth: number = 500;
  imageMargin: number = 2;

  constructor() { }

  toggleImg(): void {
    this.showImage = !this.showImage;
  }

}
