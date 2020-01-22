export interface IDish {
  id: number;
  description: string;
  prepareTime: number;
  difficultyLevel: string;
  numberOfServings: number;
  photoURL: string;
}

export class Dish implements IDish {
  private _id: number;
  private _description: string;
  private _prepareTime: number;
  private _difficultyLevel: string;
  private _numberOfServings: number;
  private _photoURL: string;

  setId(id: number): void {
    this._id = id;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get prepareTime(): number {
    return this._prepareTime;
  }

  set prepareTime(value: number) {
    this._prepareTime = value;
  }

  get difficultyLevel(): string {
    return this._difficultyLevel;
  }

  set difficultyLevel(value: string) {
    this._difficultyLevel = value;
  }

  get numberOfServings(): number {
    return this._numberOfServings;
  }

  set numberOfServings(value: number) {
    this._numberOfServings = value;
  }

  get photoURL(): string {
    return this._photoURL;
  }

  set photoURL(value: string) {
    this._photoURL = value;
  }
}
