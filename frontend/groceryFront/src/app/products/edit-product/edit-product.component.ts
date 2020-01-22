import { Component } from '@angular/core';
import { Product } from "../../dish/product";
import { ActivatedRoute, Router } from "@angular/router";
import { ProductService } from "../product.service";
import { Unit } from "../../model/unit";
import {UnitService} from "../../service/unit.service";
import {ProductCategory} from "../productCategory";

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html'
})
export class EditProductComponent {

  product: Product;
  id: number;
  units: Unit[];
  unitSelected: Unit;
  categories: ProductCategory[];
  categorySelected: string;

  constructor(private _route: ActivatedRoute,
              private _productService: ProductService,
              private _unitsService: UnitService,
              private _router: Router) {
    this.id = this._route.snapshot.params['id'];
    this._productService.getProduct(this._route.snapshot.params['id'])
      .subscribe( (data) => {
        this.product = data;
        this.unitSelected = new Unit(this.product.unit);
      });
    this._unitsService.getUnitObservables()
      .subscribe( (data) => {
        this.units = data;
      });
    this._productService.getProductObservables().subscribe(
      (data) => {
        this.categories = data;
      }
    );
  }

  cancel(): void {
    this._router.navigate(['/product']).catch();
  }

  editProduct(productForm): void {
    let resultProduct = new Product();
    resultProduct.setId(this.id);
    resultProduct.setName(productForm.product);
    resultProduct.setProductCategory(this.categorySelected);
    resultProduct.setUnit(this.unitSelected.unitName);
    this._productService.editProduct(resultProduct);
  }

  setUnitSelected(name) {
    this.unitSelected.setName(name.target.value);
  }

  setProductCategory(category) {
    this.categorySelected = category.target.value;
  }

}
