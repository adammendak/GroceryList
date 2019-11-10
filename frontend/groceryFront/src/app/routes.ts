import { ErrorComponent } from "./error/error.component";
import { WelcomeComponent } from "./welcome/welcome.component";
import { LoginComponent } from "./user/login";
import { MylistComponent } from "./mylist/mylist.component";
import { DishComponent } from "./dish/dish.component";
import { DishDetailComponent } from "./dish/dish-detail/dish-detail.component";

export const routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'user/login', component: LoginComponent},
  {path: 'mylist', component: MylistComponent},
  {path: 'dish', component: DishComponent},
  {path: 'dish/:id', component: DishDetailComponent},
  {path: '', redirectTo: 'welcome', pathMatch: 'full'},
  {path: '**', redirectTo: 'error'}
];
