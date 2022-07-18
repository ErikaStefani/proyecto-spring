import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { catchError, finalize, Observable, throwError } from "rxjs";
import { AppToastService, AuthService } from "../../shared";
import { LoaderService } from "../../shared/components/loader/loader.service";

@Injectable()
export class HttpResponseStatusInterceptor implements HttpInterceptor {

  constructor(
    private authService: AuthService,
    private router: Router,
    private appToastService: AppToastService,
    private loaderService: LoaderService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(req).pipe(
      catchError(err => {
        if (err instanceof HttpErrorResponse) {
          if (err.status === 401 || err.status === 403) {
            // Invalidate user session and redirect to login/home
            this.authService.logout();
            this.router.navigate(['/login']);
          }
          else if (err.status === 400) {
            this.checkError(err);
          } else {
            this.appToastService.showError(err.message);
          }

          // return the error back to the caller
          return throwError(() => err);
        }
      }),
      finalize(() => {
        this.loaderService.hideSpinner()
      })
    );
  }

  checkError(httpErrorResponse: HttpErrorResponse) {
    if (httpErrorResponse.error) {
      if (httpErrorResponse.error.isApplicationError) {
        this.appToastService.showWarning(httpErrorResponse.error.message);
      } else if (httpErrorResponse.error.errors) {
        for (const key in httpErrorResponse.error.errors) {
          this.appToastService.showWarning(httpErrorResponse.error.errors[key]);
        };
      }
    }
  }
}