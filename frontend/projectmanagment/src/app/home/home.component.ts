import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import{CurrentUser} from "../model/CurrentUser";
import {CurrentUserService} from "../service/currentUser.service";
import {TokenStorage} from "../login/token.storage";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit{

  currentUser: CurrentUser = new CurrentUser();

  constructor(private currentUserService: CurrentUserService,
              private token: TokenStorage,
              private router: Router){

  }

  ngOnInit(){

    this.currentUserService.getUser(this.token.getToken()).subscribe( user =>{
      this.currentUser = user;
    })

  }

  public logOut(){
    this.token.signOut();
    this.router.navigate([''])
  }

}
