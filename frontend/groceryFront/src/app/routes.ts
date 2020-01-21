import { ErrorComponent } from "./error/error.component";
import { WelcomeComponent } from "./welcome/welcome.component";
import { LoginComponent } from "./user/login";
import { MylistComponent } from "./mylist/mylist.component";
import { DishComponent } from "./dish/dish.component";
import { DishDetailComponent } from "./dish/dish-detail/dish-detail.component";
import { SignInComponent } from "./user/sign-in/sign-in.component";
import { ProductsComponent } from "./products/products.component";
import { AddProductComponent } from "./products/add-product/add-product.component";
import {AddProductCategoryComponent} from "./products/add-product-category/add-product-category.component";
import {EditProductCategoryComponent} from "./products/edit-product-category/edit-product-category.component";

export const routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'user/login', component: LoginComponent},
  {path: 'user/signUp', component: SignInComponent},
  {path: 'mylist', component: MylistComponent},
  {path: 'product', component: ProductsComponent},
  {path: 'addProduct', component: AddProductComponent},
  {path: 'addProductCategory', component: AddProductCategoryComponent},
  {path: 'editProductCategory/:id', component: EditProductCategoryComponent},
  {path: 'dish', component: DishComponent},
  {path: 'dish/:id', component: DishDetailComponent},
  {path: '', redirectTo: 'welcome', pathMatch: 'full'},
  {path: '**', redirectTo: 'error'}
];
