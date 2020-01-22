import { Component } from '@angular/core';
import { IDish } from "../model/dish";
import { IProduct } from "../model/product";

@Component({
  selector: 'app-mylist',
  templateUrl: './mylist.component.html'
})
export class MylistComponent {

  pageTitle: string = "My Grocery List";
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
