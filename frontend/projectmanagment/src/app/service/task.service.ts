import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Task} from "../model/Task";
import {Observable} from "rxjs";
import {User} from "../model/User";

@Injectable({
  providedIn: 'root'
})

export class TaskService {

  constructor(private http: HttpClient) {
  }

  saveTask(task: Task): Observable<Task> {
    return this.http.post<Task>('http://localhost:8081/api/pm/task/', task);
  }

  getTasks(): Observable<Task[]>{
    return this.http.get<Task[]>('http://localhost:8081/api/pm/task');
  }

  getTasksById(id: number): Observable<Task> {
    return this.http.get<Task>('http://localhost:8081/api/pm/task/'+ id);
  }

  deleteTask(taskId: string): Observable<void> {
    return this.http.delete<void>('http://localhost:8081/api/pm/task/' + taskId);
  }

  getTasksByOffset(offset): Observable<Task[]>{
    return this.http.get<Task[]>('http://localhost:8081/api/pm/task/offset/?offset=' + offset);
  }

  getTaskByCode(code: string): Observable<Task[]>{
    return this.http.get<Task[]>('http://localhost:8081/api/pm/task/code/?code=' + code)
  }
}
