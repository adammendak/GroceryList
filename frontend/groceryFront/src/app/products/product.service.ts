import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { ProductCategory } from "./productCategory";
import { applicationProperties } from "../properties";
import { Observable } from "rxjs";
import { Product } from "../dish/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  urlCategories = applicationProperties.productCategoryApi;

  urlProducts = applicationProperties.productApi;

  productCategories: ProductCategory[];

  constructor(private http: HttpClient,
              private _router: Router,
              private toastr: ToastrService) {
    this.getAllProductCategories();
  }

  addProductCategory(name: string) {
    let productCategory = new ProductCategory();
    let resultProductCategory;

    productCategory.setName(name);

    this.http.post<ProductCategory>(this.urlCategories , productCategory).subscribe(
      (data) => {
        resultProductCategory = data;
        this.showCreated('Product Category created Successfully!');
        this._router.navigate(['/product']).catch();
      },
      (error) => {
        this.showError('PRODUCT CATEGORY CREATION FAILED');
        this._router.navigate(['/product']).catch();
      }
    );
  }

  editCategoryForm(name: string, id: number) {
    let result = new ProductCategory();
    result.setName(name);
    result.setId(id);
    this.http.put(this.urlCategories + '/' + id, result).subscribe(
      (data) => {
        this._router.navigate(['/product']).catch();
        this.showCreated('PRODUCT CATEGORY UPDATED!')
      },
    );
  }

  editProduct(product: Product) {
    console.log(product);
    console.log("INSIDE SERVICE");
  }

  getProductCategory(id: number): Observable<ProductCategory>{
    return this.http.get<ProductCategory>(this.urlCategories+ '/' + id);
  }

  getProduct(id: number): Observable<Product>{
    return this.http.get<Product>(this.urlProducts+ '/' + id);
  }

  getAllProductCategories() {
    this.http.get<ProductCategory[]>(this.urlCategories).subscribe(
      (data) => {
        this.productCategories = data;
      },
      (error) => {
        this.showError('ERROR GETTING PRODUCT CATEGORIES');
        this._router.navigate(['/product']).catch();
      }
    );
  }

  deleteProductCategory(id: number) {
    this.http.delete(this.urlCategories + '/' + id).subscribe(
      (data) => {
        this._router.navigate(['/product']).catch();
        this.showError('PRODUCT CATEGORY DELETED')
      },
    );
  }

  deleteProduct(id: number) {
    this.http.delete(this.urlProducts + '/' + id).subscribe(
      (data) => {
        this._router.navigate(['/product']).catch();
        this.showError('PRODUCT DELETED')
      },
    );
  }

  getProductObservables(): Observable<ProductCategory[]> {
    return this.http.get<ProductCategory[]>(this.urlCategories);
  }

  getProductsForCategory(name: string): Observable<Product[]> {
    return this.http.get<Product[]>(this.urlProducts + '/getByName/' + name);
  }

  showCreated(text: string) {
    this.toastr.success( text);
  }

  showError(text: string) {
    this.toastr.error(text);
  }

}
