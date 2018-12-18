
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Priority} from "../model/Priority";
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class PriorityService {

  constructor(private http: HttpClient) {
  }

  getPriority(): Observable<Priority[]> {
    return this.http.get<Priority[]>('http://localhost:8081/api/pm/priority');
  }

}
