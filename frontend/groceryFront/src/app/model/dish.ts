import { DishCategory } from "./dishCategory";

export interface IDish {
  id: number;
  description: string;
  prepareTime: number;
  difficultyLevel: string;
  numberOfServings: number;
  categories: DishCategory;
}

export class Dish implements IDish {
  id: number;
  description: string;
  prepareTime: number;
  difficultyLevel: string;
  numberOfServings: number;
  categories: DishCategory[];

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

  setCategory(value: DishCategory[]) {
    this.categories = value;
  }
}
