import { Component } from '@angular/core';
import { UserAuthService } from "../service/user-auth.service";
import { Router } from "@angular/router";
import { ProductService } from "../service/product.service";
import { ProductCategory } from "../model/productCategory";
import { ToastrService } from "ngx-toastr";
import { Product } from "../model/product";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html'
})
export class ProductsComponent {

  productCategories: ProductCategory[];
  products: Product[];

  constructor(public _auth: UserAuthService,
              public _product: ProductService,
              private _router: Router,
              private toastr: ToastrService) {
    this.getLocalProductCategories();
  }

  goToAddProducts() {
    this._router.navigate(['/addProduct']).catch();
  }

  goToAddProductCategories() {
    this._router.navigate(['/addProductCategory']).catch();
  }

  deleteCategory(id: number) {
    this._product.deleteProductCategory(id);
    this.getLocalProductCategories();
    this._router.navigate(['/welcome']).catch();
    this.toastr.error('PRODUCT CATEGORY DELETED');
  }

  deleteProduct(id: number) {
    this._product.deleteProduct(id);
    this._router.navigate(['/welcome']).catch();
  }

  editProduct(id: number) {
    this._router.navigate(['/editProduct/' + id]).catch();
  }

  editCategory(id: number) {
    this._router.navigate(['/editProductCategory/' + id]).catch();
  }

  private getLocalProductCategories() {
    this._product.getProductObservables().subscribe(
      (data) => {
        this.productCategories = data;
        this.getProductsForCategory(this.productCategories[0].name)
      }
    );
  }

  getProductsForCategory(id: string) {
    this._product.getProductsForCategory(id).subscribe(
      (data) => {
        this.products = data;
      }
    )
  }

  getProductsForCategoryEvent(id) {
    this._product.getProductsForCategory(id.target.value).subscribe(
      (data) => {
        this.products = data;
      }
    )
  }

}
