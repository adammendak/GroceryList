export interface IProductCategory {
  name: string;
}

export class ProductCategory implements IProductCategory {
  name: string;

  setName(name: string): void {
    this.name = name;
  }
}
