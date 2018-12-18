import { Injectable } from '@angular/core';
import {HttpInterceptor, HttpRequest, HttpHandler, HttpSentEvent, HttpHeaderResponse, HttpProgressEvent,
  HttpResponse, HttpUserEvent, HttpErrorResponse} from '@angular/common/http';
import {Observable, throwError} from "rxjs";
import { Router } from '@angular/router';
import {TokenStorage} from './token.storage';
import {tap} from "rxjs/operators";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {catchError} from "rxjs/operators";

modalRef: BsModalRef;

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class Interceptor implements HttpInterceptor {

  constructor(private token: TokenStorage, private router: Router,private modalService: BsModalService,) { }

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpSentEvent | HttpHeaderResponse | HttpProgressEvent | HttpResponse<any> | HttpUserEvent<any>> {
    let authReq = req;
    if (this.token.getToken() != null) {
      authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this.token.getToken())});
    }
    return next.handle(authReq).pipe(
      catchError(err => {
          if (err.status === 401) {
            this.router.navigateByUrl('');
            alert("incorrectly input login or password")
          }

          const error = err.error.message;
          return throwError(error);
        }
      ));
  }
}
