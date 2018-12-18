import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import{HomeComponent} from './home/home.component';
import { AppComponent } from './app.component';
import {UserComponent} from "./home/user/user.component";
import { ModalModule } from 'ngx-bootstrap/modal'
import {TaskComponent} from "./home/task/task.component";
import {ProjectComponent} from "./home/project/project.component";
import { FormsModule }   from '@angular/forms';
import {TableComponent} from "./home/table/table.component";
import { ReactiveFormsModule } from '@angular/forms';
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {EditTaskComponent} from "./editTask/editTask.component";
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AuthService} from "./login/auth.service";
import {Interceptor} from "./login/inteceptor";
import {TokenStorage} from "./login/token.storage";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";

const appRoutes: Routes =[
  { path: '', component: LoginComponent},
  { path: 'home', component: HomeComponent},
  { path: 'edit', component: EditTaskComponent},
];

@NgModule({
  declarations: [
    LoginComponent,
    TableComponent,
    AppComponent,
    HomeComponent,
    UserComponent,
    TaskComponent,
    ProjectComponent,
    EditTaskComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    Ng4LoadingSpinnerModule.forRoot(),
    ReactiveFormsModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule.forRoot(),

  ],
  providers:  [ AuthService, TokenStorage,

    {provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi : true}

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
