export interface IProduct {
  id: number;
  name: string;
  unit: string;
  productCategory: string;
}

export class Product implements  IProduct {
  id: number;
  name: string;
  productCategory: string;
  unit: string;

  setId(value: number) {
    this.id = value;
  }

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
