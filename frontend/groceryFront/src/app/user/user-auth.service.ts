import { Injectable } from '@angular/core';
import { User } from "./user";
import { HttpClient } from "@angular/common/http";
import { applicationProperties } from "../properties";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  url = applicationProperties.userApi;

  currentUser: User;

  isAuthenticated: boolean = false;

  constructor(private http: HttpClient,
              private _router: Router,
              private toastr: ToastrService) { }

  loginUser(userName: string, password: string) {
    let formUser = new User();
    let resultUser;

    formUser.setUserName(userName);
    formUser.setPassword(password);

    this.http.post<User>(this.url + "/login", formUser).subscribe(
      (data) => {
        resultUser = data;
        this.isAuthenticated = true;
        this.currentUser = resultUser;
        this.showSuccess();
        this._router.navigate(['/welcome']).catch();
      },
      (error) => {
        this.showError();
        this._router.navigate(['/welcome']).catch();
      }
    );
  }

  signUp(userName: string, password: string, email: string) {
    let formUser = new User();
    let resultUser;

    formUser.setUserName(userName);
    formUser.setPassword(password);
    formUser.setEmail(email);

    this.http.post<User>(this.url , formUser).subscribe(
      (data) => {
        resultUser = data;
        this.isAuthenticated = true;
        this.currentUser = resultUser;
        this.showCreated();
        this._router.navigate(['/welcome']).catch();
      },
      (error) => {
        this.showErrorSignUp();
        this._router.navigate(['/welcome']).catch();
      }
    );
  }

  showSuccess() {
    this.toastr.success('Welcome Back ' + this.currentUser.userName + ' !', 'Login Successfull!');
  }

  showCreated() {
    this.toastr.success('Welcome to recipe App!', 'User created Successfully!');
  }

  showError() {
    this.toastr.error('Wrong Credentials', 'LOGIN FAILED');
  }

  showErrorSignUp() {
    this.toastr.error('Something went wrong with sign up, good data inserted ?', 'Ooops!');
  }
}
