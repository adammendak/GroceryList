import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserAuthService } from "./service/user-auth.service";
import { RouterModule } from "@angular/router";
import { ErrorComponent } from './error/error.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from "./user/login";
import { routes } from "./routes";
import { FormsModule } from "@angular/forms";
import { MylistComponent } from './mylist/mylist.component';
import { DishComponent } from './dish/dish.component';
import { DishDetailComponent } from './dish/dish-detail/dish-detail.component';

import { ToastrModule } from 'ngx-toastr';
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { SignInComponent } from './user/sign-in/sign-in.component';
import { ProductsComponent } from './products/products.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { AddProductCategoryComponent } from './products/add-product-category/add-product-category.component';
import { EditProductCategoryComponent } from './products/edit-product-category/edit-product-category.component';
import { EditProductComponent } from './products/edit-product/edit-product.component';
import { AddDishComponent } from './dish/add-dish/add-dish.component';
import { EditDishComponent } from './dish/edit-dish/edit-dish.component';
import { AddDishCategoryComponent } from './dish/add-dish-category/add-dish-category.component';
import { EditDishCategoryComponent } from './dish/edit-dish-category/edit-dish-category.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ErrorComponent,
    WelcomeComponent,
    LoginComponent,
    MylistComponent,
    DishComponent,
    DishDetailComponent,
    SignInComponent,
    ProductsComponent,
    AddProductComponent,
    AddProductCategoryComponent,
    EditProductCategoryComponent,
    EditProductComponent,
    AddDishComponent,
    EditDishComponent,
    AddDishCategoryComponent,
    EditDishCategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [UserAuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
