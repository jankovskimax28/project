import {Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {BsModalService, BsModalRef, ModalDirective} from 'ngx-bootstrap/modal';
import {PriorityService} from "../../service/priority.service";
import {Priority} from "../../model/Priority"
import {ProjectService} from "../../service/project.service";
import{Project} from "../../model/Project";
import {User} from "../../model/User";
import {UserSerivce} from "../../service/user.serivce";
import {TaskService} from  "../../service/task.service";
import {Task} from "../../model/Task"
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AbstractControl, FormControl, ValidationErrors, Validators} from "@angular/forms";
import {TableComponent} from "../table/table.component";

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html'
})
export class TaskComponent implements OnInit{


  @ViewChild('childModal') childModal: ModalDirective;
  modalRef: BsModalRef;
  @Input()
  role: string ;
  @Input()
  id: string;

  check: boolean = false;
  public priority: Priority[] = [];
  public projects: Project[] = [];
  public users: User[] = [];

  private subscriptions: Subscription[] = [];
  dataControl: FormControl;
  public tasks: Task[] = [];
  offset: number = 0;
  task: Task = new Task();
  constructor(private modalService: BsModalService,
              private priorityService: PriorityService,
              private projectService: ProjectService,
              private userService: UserSerivce,
              private taskService: TaskService,
              private loadingService: Ng4LoadingSpinnerService) {

  }

  ngOnInit() {
    this.priorityService.getPriority().subscribe(priority => {
      this.priority = priority as Priority[];
    });
    this.buttonCheck();

    this.dataControl = new FormControl("", [Validators.required,this.validateDate]);
    this.dataControl.valueChanges.subscribe((value) => console.log(value));


  }

  private buttonCheck(): boolean{
    if(this.role === '1'){
      this.check = true;}
    return this.check;

}

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
    this.loadProject();
    this.loadUser();
  }

  private loadProject(): void {
    this.projectService.getProjects().subscribe(projects => {
      this.projects = projects as Project[];
    });
  }

  private loadUser(): void {
    this.userService.getUsers().subscribe(users => {
      this.users = users as User[];
    });
  }


  public createTask(): void{
    this.task.updateDate = new Date().getTime();
    this.task.reporter = this.id;
    this.subscriptions.push(this.taskService.saveTask(this.task).subscribe(() => {

      this.loadingService.hide();
      this.closeModal();
    }));

  }

  public closeModal(): void {
    this.modalRef.hide();
  }


   private validateDate(control: AbstractControl): ValidationErrors | null{
  {
    var arrD = control.value.split("-");
    arrD[1] -= 1;
    var d = new Date(arrD[0], arrD[1], arrD[2]);

    if ((d.getFullYear() > arrD[0]) || (d.getMonth() > arrD[1]) || (d.getDate() > arrD[0])) {
      return {validateDate: true};
    } else {
      return null
    }
  }
  }
  private loadTask(): void {
    this.taskService.getTasksByOffset(this.offset = 0).subscribe(tasks => {
      this.tasks = tasks as Task[];
    });
  }
}
