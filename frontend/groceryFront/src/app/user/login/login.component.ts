import { Component } from '@angular/core';
import { IUser, User } from "../../model/user";
import { UserAuthService } from "../../service/user-auth.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  user: IUser = new User;

  constructor(private _userAuth: UserAuthService,
              private _router: Router) { }

  login(formValues): void {
    this._userAuth.loginUser(formValues.userName, formValues.password);
  }

  cancel(): void {
    this._router.navigate(['/welcome']).catch();
  }

}
