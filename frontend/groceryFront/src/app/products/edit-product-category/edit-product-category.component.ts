import { Component } from '@angular/core';
import { ProductService } from "../../service/product.service";
import { ActivatedRoute, Router } from "@angular/router";
import {ProductCategory} from "../../model/productCategory";

@Component({
  selector: 'app-edit-product-category',
  templateUrl: './edit-product-category.component.html'
})
export class EditProductCategoryComponent {

  productCategory: ProductCategory;
  id: number;

  constructor(private _route: ActivatedRoute,
              private _productService: ProductService,
              private _router: Router) {
    this.id = this._route.snapshot.params['id'];
    this._productService.getProductCategory(this._route.snapshot.params['id'])
      .subscribe( (data) => {
        this.productCategory = data;
      })
  }

  cancel(): void {
    this._router.navigate(['/product']).catch();
  }

  editProductCategory(productCategoryForm) {
    this._productService.editCategoryForm(productCategoryForm.productCategory, this.id);
  }

}
