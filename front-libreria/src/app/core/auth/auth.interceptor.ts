import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AuthService } from "../../shared";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (this.authService.btoa) {
      const cloned = req.clone({
        headers: req.headers.set("Authorization", "Basic " + this.authService.btoa)
      });

      return next.handle(cloned);
    }
    else {
      return next.handle(req);
    }
  }
}