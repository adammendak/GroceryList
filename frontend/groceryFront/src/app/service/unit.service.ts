import { Injectable } from '@angular/core';
import { applicationProperties } from "../properties";
import { Unit } from "../model/unit";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UnitService {

  urlUnits = applicationProperties.unitApi;

  units: Unit[];

  constructor(private http: HttpClient) {
    this.getAllUnits();
  }

  getAllUnits() {
    this.http.get<Unit[]>(this.urlUnits).subscribe(
      (data) => {
        this.units = data;
      }
    );
  }

  getUnitObservables(): Observable<Unit[]> {
    return this.http.get<Unit[]>(this.urlUnits);
  }

}
