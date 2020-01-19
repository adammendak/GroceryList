import { Component } from '@angular/core';
import {UserAuthService} from "../user/user-auth.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(public _auth: UserAuthService) { }

  logout(): void {
    this._auth.isAuthenticated = false;
    this._auth.currentUser = null;
  }

}
