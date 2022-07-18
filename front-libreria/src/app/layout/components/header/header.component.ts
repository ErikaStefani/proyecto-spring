import { Component, OnDestroy, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { Subject, takeUntil, tap} from 'rxjs';
import { AuthorizationInfo, AuthService, UserInfoDto } from '../../../shared';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit, OnDestroy {
  public pushRightClass: string;
  private authInfo: AuthorizationInfo;
  private destroy$ = new Subject<boolean>();
  
  public get currentUser() : string {
    return this.authInfo.currentUserName();
  }

  constructor(
    private translate: TranslateService,
    public router: Router,
    private authService: AuthService) {

    this.router.events.subscribe((val) => {
      if (val instanceof NavigationEnd && window.innerWidth <= 992 && this.isToggled()) {
        this.toggleSidebar();
      }
    });

    this.authService.authorizationChanges$
      .pipe(
        takeUntil(this.destroy$),
        tap(authInfo => {
          this.authInfo = authInfo;
        })
      ).subscribe();
  }

  ngOnDestroy(): void {
    this.destroy$.next(true);
  }

  ngOnInit() {
    this.pushRightClass = 'push-right';
  }

  isToggled(): boolean {
    const dom: Element = document.querySelector('body');
    return dom.classList.contains(this.pushRightClass);
  }

  toggleSidebar() {
    const dom: any = document.querySelector('body');
    dom.classList.toggle(this.pushRightClass);
  }

  rltAndLtr() {
    const dom: any = document.querySelector('body');
    dom.classList.toggle('rtl');
  }

  onLoggedout() {
    this.authService.logout();
  }

  changeLang(language: string) {
    this.translate.use(language);
  }
}
