import {AfterViewChecked, Component, OnInit} from '@angular/core';
import { UserAuthService } from "../user/user-auth.service";
import { Router } from "@angular/router";
import { ProductService } from "./product.service";
import {ProductCategory} from "./productCategory";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html'
})
export class ProductsComponent {

  productCategories: ProductCategory[];

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

  delete(id: number) {
    this._product.deleteProductCategory(id);
    this.getLocalProductCategories();
    this._router.navigate(['/welcome']).catch();
    this.toastr.error('PRODUCT CATEGORY DELETED');
  }

  edit(id: number) {
    this._router.navigate(['/editProductCategory/' + id]).catch();
  }

  private getLocalProductCategories() {
    this._product.getProductObservables().subscribe(
      (data) => {
        this.productCategories = data;
      }
    );
  }

}
