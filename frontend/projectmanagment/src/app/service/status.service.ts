import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Status} from "../model/Status";
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class StatusService {

  constructor(private http: HttpClient) {
  }

  getStatus(): Observable<Status[]> {
    return this.http.get<Status[]>('http://localhost:8081/api/pm/status/');
  }

}
