export interface IProductCategory {
  name: string;
  id: number;
}

export class ProductCategory implements IProductCategory {
  name: string;
  id: number;

  setName(name: string): void {
    this.name = name;
  }

  setId(id: number): void {
    this.id = id;
  }
}
