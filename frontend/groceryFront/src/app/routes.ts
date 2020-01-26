import { ErrorComponent } from "./error/error.component";
import { WelcomeComponent } from "./welcome/welcome.component";
import { LoginComponent } from "./user/login";
import { MylistComponent } from "./mylist/mylist.component";
import { DishComponent } from "./dish/dish.component";
import { DishDetailComponent } from "./dish/dish-detail/dish-detail.component";
import { SignInComponent } from "./user/sign-in/sign-in.component";
import { ProductsComponent } from "./products/products.component";
import { AddProductComponent } from "./products/add-product/add-product.component";
import { AddProductCategoryComponent } from "./products/add-product-category/add-product-category.component";
import { EditProductCategoryComponent } from "./products/edit-product-category/edit-product-category.component";
import { EditProductComponent } from "./products/edit-product/edit-product.component";
import { AddDishComponent } from "./dish/add-dish/add-dish.component";
import { EditDishComponent } from "./dish/edit-dish/edit-dish.component";
import { AddDishCategoryComponent } from "./dish/add-dish-category/add-dish-category.component";
import { EditDishCategoryComponent } from "./dish/edit-dish-category/edit-dish-category.component";

export const routes = [
  {path: 'error', component: ErrorComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'user/login', component: LoginComponent},
  {path: 'user/signUp', component: SignInComponent},
  {path: 'mylist', component: MylistComponent},
  {path: 'product', component: ProductsComponent},
  {path: 'addProduct', component: AddProductComponent},
  {path: 'editProduct/:id', component: EditProductComponent},
  {path: 'addProductCategory', component: AddProductCategoryComponent},
  {path: 'editProductCategory/:id', component: EditProductCategoryComponent},
  {path: 'dish', component: DishComponent},
  {path: 'addDish', component: AddDishComponent},
  {path: 'addDishCategory', component: AddDishCategoryComponent},
  {path: 'editDishCategory/:id', component: EditDishCategoryComponent},
  {path: 'editDish/:id', component: EditDishComponent},
  {path: 'dish/:id', component: DishDetailComponent},
  {path: '', redirectTo: 'welcome', pathMatch: 'full'},
  {path: '**', redirectTo: 'error'}
];
