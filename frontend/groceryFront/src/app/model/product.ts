import { ProductCategory } from "./productCategory";

export interface IProduct {
  id: number;
  name: string;
  unit: string;
  productCategory: ProductCategory;
}

export class Product implements  IProduct {
  id: number;
  name: string;
  productCategory: ProductCategory;
  unit: string;

  setId(value: number) {
    this.id = value;
  }

  setName(value: string) {
    this.name = value;
  }

  setProductCategory(value: ProductCategory) {
    this.productCategory = value;
  }

  setUnit(value: string) {
    this.unit = value;
  }
}
