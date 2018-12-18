import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Role} from "../../model/Role";

@Injectable({
  providedIn: 'root'
})

export class RoleService {

  constructor(private http: HttpClient) {
  }


  getRole(): Observable<Role[]> {
    return this.http.get<Role[]>('http://localhost:8081/api/pm/role');
  }
}
