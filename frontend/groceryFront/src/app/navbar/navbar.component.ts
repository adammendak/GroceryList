import { Component } from '@angular/core';
import {UserAuthService} from "../service/user-auth.service";
import {MyListService} from "../service/my-list.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent {

  constructor(public _auth: UserAuthService,
              private _myList: MyListService) { }

  logout(): void {
    this._auth.isAuthenticated = false;
    this._auth.currentUser = null;
  }

}
