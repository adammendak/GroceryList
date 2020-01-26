import { DishCategory } from "./dishCategory";
import { Ingredient } from "./ingredient";

export interface IDish {
  id: number;
  description: string;
  prepareTime: number;
  difficultyLevel: string;
  numberOfServings: number;
  categories: DishCategory[];
  ingredients: Ingredient[];
}

export class Dish implements IDish {
  id: number;
  description: string;
  prepareTime: number;
  difficultyLevel: string;
  numberOfServings: number;
  categories: DishCategory[];
  ingredients: Ingredient[];

  setId(id: number): void {
    this.id = id;
  }


  setDescription(value: string) {
    this.description = value;
  }

  setPrepareTime(value: number) {
    this.prepareTime = value;
  }

  setDifficultyLevel(value: string) {
    this.difficultyLevel = value;
  }

  setNumberOfServings(value: number) {
    this.numberOfServings = value;
  }

  setCategories(value: DishCategory[]) {
    this.categories = value;
  }

  setIngredients(value: Ingredient[]) {
    this.ingredients = value;
  }
}
