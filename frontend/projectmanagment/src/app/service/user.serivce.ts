import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/User";
import {Project} from "../model/Project";
import {Task} from "../model/Task";

@Injectable({
  providedIn: 'root'
})

export class UserSerivce {

  constructor(private http: HttpClient) {
  }

  saveUser(user: User): Observable<User>{
    return this.http.post<User>('http://localhost:8081/api/pm/user/', user);
  }

  getUsers(): Observable<User[]>{
    return this.http.get<User[]>('http://localhost:8081/api/pm/user');
  }

  getUserByLogin(login: any): Observable<User> {
    return this.http.get<User>('http://localhost:8081/api/pm/user/login/?login='+ login);
  }

}
