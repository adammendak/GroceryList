export interface IUnit {
  id: number;
  unitName: string;
}

export class Unit implements  IUnit {
  id: number;
  unitName: string;

  constructor(unitName: string) {
    this.unitName = unitName;
  }

  setName(value: string) {
    this.unitName = value;
  }
}
