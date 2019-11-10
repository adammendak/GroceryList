import { Component, OnInit } from '@angular/core';
import {IDish} from "./dish";
import {IProduct} from "./product";

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html',
  styleUrls: ['./dish.component.css']
})
export class DishComponent implements OnInit {

  _listFilter: string;
  showImage: boolean = false;

  filteredDishes: IDish[];
  dishes: IDish[] = [];

  products: IProduct[] = [];

  imageWidth: number = 500;
  imageMargin: number = 2;

  constructor() { }

  ngOnInit() {
  }

  toggleImg(): void {
    this.showImage = !this.showImage;
  }

}
