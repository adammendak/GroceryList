import { Component } from '@angular/core';
import { DishCategory } from "../../model/dishCategory";
import { ActivatedRoute, Router } from "@angular/router";
import { DishService } from "../../service/dish.service";

@Component({
  selector: 'app-edit-dish-category',
  templateUrl: './edit-dish-category.component.html'
})
export class EditDishCategoryComponent {

  dishCategory: DishCategory;
  id: number;

  constructor(private _route: ActivatedRoute,
              private _dishService: DishService,
              private _router: Router) {
    this.id = this._route.snapshot.params['id'];
    this._dishService.getDishCategory(this._route.snapshot.params['id'])
      .subscribe( (data) => {
        this.dishCategory = data;
        console.log(this.dishCategory)
      })
  }

  cancel(): void {
    this._router.navigate(['/dish']).catch();
  }

  editDishCatgory(dishCategoryForm) {
    this._dishService.editDishCategory(dishCategoryForm.dishCategory, this.id);
  }

}
