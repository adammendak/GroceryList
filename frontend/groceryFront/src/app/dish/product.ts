export interface IProduct {
  name: string;
  unit: string;
  productCategory: string;
}

export class Product implements  IProduct {
  name: string;
  productCategory: string;
  unit: string;

  setName(value: string) {
    this.name = value;
  }

  setProductCategory(value: string) {
    this.productCategory = value;
  }

  setUnit(value: string) {
    this.unit = value;
  }
}
