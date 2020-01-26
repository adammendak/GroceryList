import { Component } from '@angular/core';
import { Router } from "@angular/router";
import { DishService } from "../../service/dish.service";

@Component({
  selector: 'app-add-dish-category',
  templateUrl: './add-dish-category.component.html'
})
export class AddDishCategoryComponent {

  constructor(private _dishService: DishService,
              private _router: Router) { }

  cancel(): void {
    this._router.navigate(['/dish']).catch();
  }

  addDishCategory(dishCategoryDorm) : void {
      this._dishService.addDishCategory(dishCategoryDorm.dishCategory);
  }

}
