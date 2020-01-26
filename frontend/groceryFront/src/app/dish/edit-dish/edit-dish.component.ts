import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { DishService } from "../../service/dish.service";
import { Dish } from "../../model/dish";
import { DishCategory } from "../../model/dishCategory";
import { Ingredient } from "../../model/ingredient";
import { ModalDismissReasons, NgbModal, NgbModalOptions } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-edit-dish',
  templateUrl: './edit-dish.component.html'
})
export class EditDishComponent {

  dish: Dish;
  categories: DishCategory[];
  categorySelected: string;
  id: number;
  ingredients: Ingredient[];

  closeResult: string;

  constructor(private _route: ActivatedRoute,
              private _dishService: DishService,
              private _router: Router,
              private modalService: NgbModal) {
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
        this.ingredients = this.dish.ingredients;
        console.log(this.dish);
        console.log(this.ingredients);
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

  openModal(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

}
