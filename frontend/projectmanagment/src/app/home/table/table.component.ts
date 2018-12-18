import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {Task} from "../../model/Task";
import {TaskService} from "../../service/task.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html'
})
export class TableComponent implements OnInit{

  public tasks: Task[] = [];
  public tasks1: Task[] = [];

  @Input()
  role: string ;

  private subscriptions: Subscription[] = [];

  offset: number = 0;
  page: number = 1;
  button: boolean = false;
  ammount: number;

  public code: string;

  constructor(private taskService: TaskService){

  }

  ngOnInit(){
    this.countAmountOfPagies();
    this.loadTask();
  }


  public deleteTask(taskId: string): void{
    this.taskService.deleteTask(taskId).subscribe(() => {
      this.loadTask();
      this.countAmountOfPagies();
    })
  }


  public NextTask(){
    if (this.page < this.ammount) {
      this.button = false;
      this.page ++;
      this.offset += 5;
    }
    else {
      this.button = true;
    }
    this.loadTask();
  }

  public BackTask(){
    if(this.page > 1){
      this.page --;
      this.offset = this.offset - 5;
    }

    if(this.button == true){
      this.button =false;
    }
    this.loadTask();
  }

  public loadTask(): void {
    this.taskService.getTasksByOffset(this.offset).subscribe(tasks => {
      this.tasks = tasks as Task[];
    });
  }

  public countAmountOfPagies(): void{
    this.taskService.getTasks().subscribe( tasks1 => {
      this.tasks1 = tasks1 as Task[];
      let n: number;
       n = tasks1.length/5;
       this.ammount = Math.ceil(n);
    })
  }

  private loadTaskByCode(code: string): void {
    this.taskService.getTaskByCode(code).subscribe( tasks =>{
      this.tasks = tasks as Task[];
    });
  }

  public Search(code: string): void {
    this.loadTaskByCode(code);
  }
}
