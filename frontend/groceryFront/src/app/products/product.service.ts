import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { ProductCategory } from "./productCategory";
import { applicationProperties } from "../properties";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url = applicationProperties.productCategoryApi;

  constructor(private http: HttpClient,
              private _router: Router,
              private toastr: ToastrService) { }

  addProductCategory(name: string) {
    let productCategory = new ProductCategory();
    let resultProductCategory;

    productCategory.setName(name);

    this.http.post<ProductCategory>(this.url , productCategory).subscribe(
      (data) => {
        resultProductCategory = data;
        console.log("ODPOWIEDZ Z SERVERA")
        this.showCreated();
        this._router.navigate(['/product']).catch();
      },
      (error) => {
        this.showError();
        this._router.navigate(['/product']).catch();
      }
    );
  }

  showCreated() {
    this.toastr.success( 'Product Category created Successfully!');
  }

  showError() {
    this.toastr.error('PRODUCT CATEGORY CREATION FAILED');
  }

}
