import { ErrorComponent } from "./error/error.component";
import { WelcomeComponent } from "./welcome/welcome.component";
import { LoginComponent } from "./user/login";
import { MylistComponent } from "./mylist/mylist.component";

export const routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'user/login', component: LoginComponent},
  {path: 'mylist', component: MylistComponent},
  {path: '', redirectTo: 'welcome', pathMatch: 'full'},
  {path: '**', redirectTo: 'error'}
];
