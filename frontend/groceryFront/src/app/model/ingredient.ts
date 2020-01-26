import {Product} from "./product";

export interface IIngredient {
  id: number;
  quantity: number;
  product: Product;
}

export class Ingredient implements IIngredient {
  id: number;
  quantity: number;
  product: Product;

  setId(value: number) {
    this.id = value;
  }

  setQuantity(value: number) {
    this.quantity = value;
  }

  setProduct(value: Product) {
    this.product = value;
  }
}
