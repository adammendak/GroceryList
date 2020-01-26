import { Component } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { DishService } from "../../service/dish.service";
import { Dish } from "../../model/dish";
import { DishCategory } from "../../model/dishCategory";

@Component({
  selector: 'app-edit-dish',
  templateUrl: './edit-dish.component.html'
})
export class EditDishComponent {

  dish: Dish;
  categories: DishCategory[];
  categorySelected: string;
  id: number;

  constructor(private _route: ActivatedRoute,
              private _dishService: DishService,
              private _router: Router) {
    this.getDishCategories();
    this.getDish();
  }

  editDish(dishForm) {
    let resultDish = new Dish();
    let dishCategory = new DishCategory();
    dishCategory.setName(this.categorySelected);
    let dishCategories: DishCategory[] = [dishCategory];

    resultDish.setId(this.id);
    resultDish.setDescription(dishForm.value.description);
    resultDish.setPrepareTime(dishForm.value.prepareTime);
    resultDish.setDifficultyLevel(dishForm.value.difficultyLevel);
    resultDish.setNumberOfServings(dishForm.value.numberOfServings);
    resultDish.setCategories(dishCategories);
    this._dishService.editDish(resultDish);
  }

  isSelectedCategory(name:string) {
    return name === this.categorySelected;
  }

  setDishCategory(category) {
    this.categorySelected = category.target.value;
  }

  private getDish() {
    this._dishService.getDish(this._route.snapshot.params['id'])
      .subscribe((data) => {
        this.dish = data;
        this.categorySelected = this.dish.categories[0].name;
        this.id = this.dish.id;
      });
  }

  private getDishCategories() {
    this._dishService.getDishCategories().subscribe(
      (data) => {
        this.categories = data;
      })
  }

  cancel(): void {
    this._router.navigate(['/dish']).catch();
  }

}
