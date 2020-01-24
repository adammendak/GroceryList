export interface IDishCategory {
  name: string;
  id: number;
}

export class DishCategory implements IDishCategory {
  name: string;
  id: number;

  setName(name: string): void {
    this.name = name;
  }

  setId(id: number): void {
    this.id = id;
  }
}
