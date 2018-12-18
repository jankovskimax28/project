import {Component, OnInit, TemplateRef} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";
import {Task} from "../model/Task";
import {Status} from "../model/Status";
import {TaskService} from "../service/task.service";
import {Project} from "../model/Project";
import {User} from "../model/User";
import {UserSerivce} from "../service/user.serivce";
import {Priority} from "../model/Priority";
import {PriorityService} from "../service/priority.service";
import {StatusService} from "../service/status.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";


@Component({
  selector: 'app-editTask',
  templateUrl: './editTask.component.html'
})
export class EditTaskComponent implements OnInit {
  private editBatton: boolean = true;

  private id: number;

  private querySubscription: Subscription;

  public users: User[] = [];
  public priority: Priority[] = [];
  public status: Status[] = [];
  task: Task = new Task();
  role: string;

  constructor(private route: ActivatedRoute,
              private taskService: TaskService,
              private userService: UserSerivce,
              private priorityService: PriorityService,
              private statusService: StatusService,
              private loadingService: Ng4LoadingSpinnerService) {

  }

  ngOnInit() {
    this.querySubscription = this.route.queryParams.subscribe(
      (queryParam: any) => {
        this.id = queryParam['id'];
        this.role = queryParam['role']
      });
    this.loadTask(this.id);
    this.loadUser();
    this.loadPriority();
    this.loadStatus();
  }


  public loadTask(id: number): void {

    this.taskService.getTasksById(id).subscribe(task => {
      this.task = task;
    });

  }

  public editTaskOn(): void {
    if (this.editBatton == true) {
      this.editBatton = false;
    }
    else{
      this.editBatton = true;
    }
  }

  private loadUser(): void {
    this.userService.getUsers().subscribe(users => {
      this.users = users as User[];
    });
  }

  private loadPriority(): void {
    this.priorityService.getPriority().subscribe(priority => {
      this.priority = priority as Priority[];
    });
  }

  private loadStatus(): void {
    this.statusService.getStatus().subscribe(status1 => {
      this.status = status1 as Status[];
    });
  }

  updateTask(): void {
    this.loadingService.show()
    this.task.updateDate = new Date().getTime();
    this.taskService.saveTask(this.task).subscribe(
      () => {
      }
    )
  }
}
