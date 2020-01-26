import { Component } from '@angular/core';
import { DishService } from "../../service/dish.service";
import { Router } from "@angular/router";
import { DishCategory } from "../../model/dishCategory";
import { Dish } from "../../model/dish";

@Component({
  selector: 'app-add-dish',
  templateUrl: './add-dish.component.html'
})
export class AddDishComponent {

  categories: DishCategory[];
  categorySelected: string;

  constructor(public _dish: DishService,
              private _router: Router) {
    this._dish.getDishCategories().subscribe(
      (data) => {
        this.categories = data;
        this.categorySelected = this.categories[0].name;
      })
  }

  addDish(dishForm) {
    let resultDish = new Dish();
    let dishCategory = new DishCategory();
    dishCategory.setName(this.categorySelected);
    let dishCategories: DishCategory[] = [dishCategory];

    resultDish.setDescription(dishForm.value.description);
    resultDish.setPrepareTime(dishForm.value.prepareTime);
    resultDish.setDifficultyLevel(dishForm.value.difficultyLevel);
    resultDish.setNumberOfServings(dishForm.value.numberOfServings);
    resultDish.setCategories(dishCategories);
    console.log(resultDish);
    this._dish.addDish(resultDish);
  }

  setDishCategory(category) {
    this.categorySelected = category.target.value;
  }

  isSelected(name:string) {
    return name === this.categorySelected;
  }

  cancel(): void {
    this._router.navigate(['/dish']).catch();
  }
}
