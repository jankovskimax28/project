import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CurrentUser} from "../model/CurrentUser";

@Injectable({
  providedIn: 'root'
})

export class CurrentUserService {

  public login: string;


  constructor(private http: HttpClient) {
  }


  getUser(token: string): Observable<CurrentUser>{
    return this.http.get<CurrentUser>('http://localhost:8081/api/pm/user/token/' + token);
  }


  public getCurrentUser(): string  {
    return this.login;
  }

  public setCurrentUSer(login: string): void {
    this.login = login;
  }
}
