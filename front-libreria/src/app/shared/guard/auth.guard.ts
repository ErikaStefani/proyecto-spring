import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router } from '@angular/router';
import { Observable, of, take, tap } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(
    private router: Router,
    private authService: AuthService) { }

  canActivate(route: ActivatedRouteSnapshot) {
    return this.checkActivation(route);
  }

  checkActivation(route: ActivatedRouteSnapshot): Observable<boolean> {
    return this.checkLogin();
  }

  checkLogin() {
    return of(this.authService.isLoggedIn())
      .pipe(
        take(1),
        tap(result => {
          if (result === false) {
            this.redirectToLogin();
          }
        })
      );
  }

  redirectToLogin() {
    this.router.navigate(['/login']);
  }
}
