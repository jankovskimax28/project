import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Project} from "../model/Project";


@Injectable({
  providedIn: 'root'
})

 export class ProjectService {

  constructor(private http: HttpClient) {
  }

  saveProject(project: Project): Observable<Project> {
    return this.http.post<Project>('http://localhost:8081/api/pm/project/', project);
  }

  getProjects(): Observable<Project[]>{
    return this.http.get<Project[]>('http://localhost:8081/api/pm/project');
  }
}
