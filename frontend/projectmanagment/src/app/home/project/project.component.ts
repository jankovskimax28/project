import {Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import {Subscription} from "rxjs/internal/Subscription";
import {Project} from "../../model/Project";
import {ProjectService} from "../../service/project.service";
import {FormControl, Validators} from "@angular/forms";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import { ModalDirective } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html'
})
export class ProjectComponent implements  OnInit {

  @ViewChild('childModal') childModal: ModalDirective;
  @Input()
    role: string;
  projectControl: FormControl;
  modalRef: BsModalRef;
  project: Project = new Project();
  public projects: Project[] = [];

  private subscriptions: Subscription[] = [];

  constructor(private modalService: BsModalService,
              private projectService: ProjectService,
              private loadingService: Ng4LoadingSpinnerService) {

  }

  ngOnInit() {
    this.projectControl = new FormControl("", [Validators.required, Validators.pattern(/^\S{0,50}$/),
      Validators.minLength(3), Validators.maxLength(10)]);
    this.projectControl.valueChanges.subscribe((value) => this.project.projectcode = value);

  }

  public openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  public createProject(): void {
    this.loadingService.show();
    this.subscriptions.push(this.projectService.saveProject(this.project).subscribe(() => {
    this.loadingService.hide();
      this.closeModal();
      this.showChildModal();
    }));

  }

  showChildModal(): void {
    this.childModal.show();
  }

  hideChildModal(): void {
    this.childModal.hide();
  }
}
