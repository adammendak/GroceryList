import { Component } from '@angular/core';
import { IUser, User } from "../user";
import { UserAuthService } from "../user-auth.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
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
