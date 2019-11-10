export interface IProduct {
  name: string;
  unit: string;
  quantity: number;
  productCategory: string;
}

export class Product implements  IProduct {
  private _name: string;
  private _productCategory: string;
  private _quantity: number;
  private _unit: string;


  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get productCategory(): string {
    return this._productCategory;
  }

  set productCategory(value: string) {
    this._productCategory = value;
  }

  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }

  get unit(): string {
    return this._unit;
  }

  set unit(value: string) {
    this._unit = value;
  }
}
