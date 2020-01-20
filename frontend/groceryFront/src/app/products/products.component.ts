import { Component } from '@angular/core';
import { UserAuthService } from "../user/user-auth.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {

  constructor(public _auth: UserAuthService,
              private _router: Router) { }

  goToAddProducts() {
    this._router.navigate(['/addProduct']).catch();
  }

  goToAddProductCategories() {
    this._router.navigate(['/addProductCategory']).catch();
  }

}
