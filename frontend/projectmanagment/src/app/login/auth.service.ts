import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthService {


  constructor(private http: HttpClient) {
  }

  attemptAuth(login: string, password: string): Observable<any> {
    const credentials = {login: login, password: password};
    console.log('attempAuth ::');
    return this.http.post<any>('http://localhost:8081/api/token/generate-token', credentials);
  }

}
