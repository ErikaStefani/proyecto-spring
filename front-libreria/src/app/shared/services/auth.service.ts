import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, of, switchMap } from 'rxjs';
import { ApiEndpointService } from './api-endpoint.service';
import {
  AuthorizationInfoDto,
  AuthorizationInfo,
  UserModel,
} from '../../shared';
import { HttpService } from '../../core';
import { LoaderService } from '../components/loader/loader.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly AUTH_INFO = 'auth_info';

  private authorizationInfo: AuthorizationInfo;
  btoa: string;

  private authorizationChangesSubject$: BehaviorSubject<AuthorizationInfo>;
  authorizationChanges$: Observable<AuthorizationInfo>;

  constructor(
    private httpService: HttpService,
    private apiEndpointService: ApiEndpointService,
    private loaderService: LoaderService) {

    this.authorizationChangesSubject$ = new BehaviorSubject<AuthorizationInfo>(this.authorizationInfo);
    this.authorizationChanges$ = this.authorizationChangesSubject$.asObservable();
  }

  isLoggedIn(){
    if(this.authorizationInfo){
      return this.authorizationInfo.authenticated();
    }
    return false;
  }

  login(user: UserModel): Observable<boolean> {
    this.loaderService.showSpinner();
    return this.authenticateUser(user)
      .pipe(
        switchMap(authInfo => {
          return this.isValidUser(authInfo);
        })
      );
  }

  logout() {
    localStorage.removeItem(this.AUTH_INFO);
  }

  private setAuthInfoSession() {
    if (this.btoa) {
      localStorage.setItem(this.AUTH_INFO, this.btoa);
    }
  }

  private isValidUser(authInfo: AuthorizationInfoDto): Observable<boolean> {
    if (authInfo && authInfo.authenticated) {
      this.setAuthInfoSession();
      this.authorizationInfo = AuthorizationInfo.create(authInfo);
      this.authorizationChangesSubject$.next(this.authorizationInfo);
      return of(true);
    } else {
      return of(false);
    }
  }

  private authenticateUser(user: UserModel): Observable<AuthorizationInfoDto> {
    this.btoa = btoa(user.name + ':' + user.password);
    // const headers = new HttpHeaders({authorization: 'Basic ' + this.btoa})
    return this.httpService.get<AuthorizationInfoDto>(this.apiEndpointService.getAutenticarEndpoint());
  }
}
