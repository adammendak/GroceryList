import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { Dish } from "../model/dish";
import {Observable} from "rxjs";
import {applicationProperties} from "../properties";

@Injectable({
  providedIn: 'root'
})
export class DishService {

  dishes: Dish[];
  urlDish = applicationProperties.dishApi;

  constructor(private http: HttpClient,
              private _router: Router,
              private toastr: ToastrService) {
  }

  getDishes(): Observable<Dish[]> {
    return this.http.get<Dish[]>(this.urlDish);
  }

}
