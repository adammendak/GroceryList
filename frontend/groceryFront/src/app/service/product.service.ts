import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { ProductCategory } from "../model/productCategory";
import { applicationProperties } from "../properties";
import { Observable } from "rxjs";
import { Product } from "../model/product";

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
      },error => {
        this._router.navigate(['/product']).catch();
      }
    );
  }

  editProduct(product: Product) {
    this.http.put(this.urlProducts + '/' + product.id, product).subscribe(
      (data) => {
        this._router.navigate(['/product']).catch();
        this.showCreated('PRODUCT UPDATED!');
      }, error => {
        this._router.navigate(['/product']).catch();
      }
    );
  }

  addProduct(product: Product) {
    this.http.post(this.urlProducts, product).subscribe(
      (data) => {
        this._router.navigate(['/product']).catch();
        this.showCreated('PRODUCT ADDED!');
      }, error => {
        this.showError('ERROR ADDING PRODUCT');
      }
    );
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
      (error) => {
        this.showError('PRODUCT CATEGORY DELETED');
        this._router.navigate(['/product']).catch();
      }
    );
  }

  deleteProduct(id: number) {
    this.http.delete(this.urlProducts + '/' + id).subscribe(
      (data) => {
        this._router.navigate(['/product']).catch();
        this.showError('PRODUCT DELETED')
      },
      (error) => {
        this.showError('PRODUCT DELETED');
        this._router.navigate(['/product']).catch();
      }
    );
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.urlProducts);
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
