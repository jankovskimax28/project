import {Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {BsModalService, BsModalRef, ModalDirective} from 'ngx-bootstrap/modal';
import {RoleService} from "../../service/role/role.service";
import {Role} from "../../model/Role";
import {User} from "../../model/User";
import {UserSerivce} from "../../service/user.serivce";
import {Subscription} from "rxjs";
import {AbstractControl, FormControl, ValidationErrors, Validators} from "@angular/forms";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {invalid} from "@angular/compiler/src/render3/view/util";
import {Task} from "../../model/Task";


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent implements OnInit{

  @ViewChild('childModal') childModal: ModalDirective;
  @Input()
  role: string ;
  userControl: FormControl;
  passwordControl: FormControl;
  emailControl: FormControl;
  modalRef: BsModalRef;
  public roles: Role[] = [];
  public users: User[] = [];
  public user: User =  new User;
  public user1: User =  new User;

  private subscriptions: Subscription[] = [];

  constructor(private modalService: BsModalService,
              private  roleService: RoleService,
              private userService: UserSerivce,
              private loadingService: Ng4LoadingSpinnerService) {

  }
  ngOnInit() {
    this.roleService.getRole().subscribe(roles => {
      this.roles = roles as Role[];
      this.loadUser();
    });

    this.userControl = new FormControl( "", [Validators.required, Validators.pattern(/^\S{0,50}$/),
      Validators.minLength(3), Validators.maxLength(10)]);
    this.userControl.valueChanges.subscribe((value) => this.user.login = value);

    this.passwordControl = new FormControl("", [Validators.required, Validators.pattern(/^\S{0,50}$/),
      Validators.minLength(5), Validators.maxLength(15)]);
    this.passwordControl.valueChanges.subscribe((value) => this.user.password = value);

    this.emailControl = new FormControl("", [Validators.required, Validators.pattern(/^\S{0,50}$/),
      Validators.email]);
    this.emailControl.valueChanges.subscribe((value) => this.user.email = value);

  }

  openModal(template: TemplateRef<any>) {
    let user1: User = new User();

    this.modalRef = this.modalService.show(template);
  }

  public createUser(): void{
    this.loadingService.show();
    this.subscriptions.push(this.userService.saveUser(this.user).subscribe(() => {
      this.loadingService.hide();
      this.closeModal();
      this.showChildModal();}));
  }

  public closeModal(): void {
    this.modalRef.hide();
  }


  private loadUser(): void {
    this.userService.getUsers().subscribe(users => {
      this.users = users as User[];
    });
  }

  private userCheckValidator(control: AbstractControl): ValidationErrors | null  {
    this.loadUser();
    for (var i = 0; i < this.users.length; i++) {
     this.user1 = this.users[i];
    }
      if (control.value == this.user1.login) {
        return {userCheckValidator : true};
      }
      else return null;
    }

  showChildModal(): void {
    this.childModal.show();
  }

  hideChildModal(): void {
    this.childModal.hide();
  }

}

