import { Component } from '@angular/core';
import {UserAuthService} from "../../service/user-auth.service";
import {Router} from "@angular/router";
import {IUser, User} from "../../model/user";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html'
})
export class SignInComponent {

  user: IUser = new User;

  constructor(private _userAuth: UserAuthService,
              private _router: Router) { }

  signUp(formValues): void {
    this._userAuth.signUp(formValues.userName, formValues.password, formValues.email);
  }

  cancel(): void {
    this._router.navigate(['/welcome']).catch();
  }

}
