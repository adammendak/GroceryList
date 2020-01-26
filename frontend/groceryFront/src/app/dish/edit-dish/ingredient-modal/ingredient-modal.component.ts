import {Component, HostListener, Inject} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { Ingredient } from "../../../model/ingredient";

@Component({
  selector: 'app-ingredient-modal',
  templateUrl: './ingredient-modal.component.html'
})
export class IngredientModalComponent {

  ingredient: Ingredient;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: Ingredient,
    public dialogRef: MatDialogRef<IngredientModalComponent>) {
    dialogRef.disableClose = true;
    if(data) {
      this.ingredient = data;
    }
  }

  @HostListener('window:keyup.esc') onKeyUp() {
    this.dialogRef.close();
  }

  cancelModal(): void {
    this.dialogRef.close();
  }

  save() {
    this.dialogRef.close(this.ingredient);
  }

}
