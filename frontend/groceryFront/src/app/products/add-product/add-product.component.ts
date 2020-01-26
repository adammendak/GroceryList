import { Component, OnInit } from '@angular/core';
import { Product } from "../../model/product";
import { Unit } from "../../model/unit";
import { ProductCategory } from "../../model/productCategory";
import { Router } from "@angular/router";
import { ProductService } from "../../service/product.service";
import { UnitService } from "../../service/unit.service";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html'
})
export class AddProductComponent {

  units: Unit[];
  unitSelected: string;
  categories: ProductCategory[];
  categorySelected: string;

  constructor(private _productService: ProductService,
              private _unitsService: UnitService,
              private _router: Router) {
    this._unitsService.getUnitObservables()
      .subscribe( (data) => {
        this.units = data;
        this.unitSelected = this.units[0].unitName;
      });
    this._productService.getProductObservables().subscribe(
      (data) => {
        this.categories = data;
        this.categorySelected = this.categories[0].name;
      }
    );
  }

  addProduct(productForm) {
    let resultProduct = new Product();
    let productCategory = new ProductCategory();
    productCategory.setName(this.categorySelected);

    resultProduct.setName(productForm.value.productName);
    resultProduct.setProductCategory(productCategory);
    resultProduct.setUnit(this.unitSelected);
    this._productService.addProduct(resultProduct);
  }

  setUnitSelected(name) {
    this.unitSelected = name.target.value;
  }

  setProductCategory(category) {
    this.categorySelected = category.target.value;
  }

  cancel(): void {
    this._router.navigate(['/product']).catch();
  }

  isSelected(name:string) {
    return name === this.categorySelected;
  }

  isSelectedUnit(name:string) {
    return name === this.unitSelected;
  }
}
