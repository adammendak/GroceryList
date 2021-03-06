import { Component } from '@angular/core';
import {IProductCategory, ProductCategory} from "../../model/productCategory";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-product-category',
  templateUrl: './add-product-category.component.html'
})
export class AddProductCategoryComponent {

  productCategory: IProductCategory = new ProductCategory();

  constructor(private _productService: ProductService,
              private _router: Router) { }

  cancel(): void {
    this._router.navigate(['/product']).catch();
  }

  addProductCategory(productCategoryForm) {
    this._productService.addProductCategory(productCategoryForm.productCategory);
  }
}
