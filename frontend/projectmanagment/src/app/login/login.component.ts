import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from './auth.service';
import {TokenStorage} from './token.storage';
import {CurrentUserService} from "../service/currentUser.service";
import {CurrentUser} from "../model/CurrentUser";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {


  constructor(private router: Router,
              private authService: AuthService,
              private token: TokenStorage,
              private currentUserService: CurrentUserService) {
  }

  login: string;
  password: string;

  authorization(): void {
    this.authService.attemptAuth(this.login, this.password).subscribe(data => {
        this.token.saveToken(data.token);
        this.router.navigate(['home']);
      }
    );
  }

}

