import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { tap } from 'rxjs';
import { routerTransition } from '../router.animations';
import { UserModel, AuthService } from '../shared';
import { fadeInAnimation } from '../shared/animations/fade-in.animation';
import { slideInOutAnimation } from '../shared/animations/slide-in-out.animation';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  animations: [routerTransition(), fadeInAnimation, slideInOutAnimation]
})
export class LoginComponent implements OnInit {

  logoImg = "assets/images/libreria_logo.png"
  loginForm: FormGroup;
  submitted = false;
  invalidUser = false;
  loader: boolean;

  constructor(
    public router: Router,
    private authService: AuthService,
    private fb: FormBuilder) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      name: ['', [Validators.required]],
      password: ['', Validators.required]
    });
  }

  get loginFormControl() {
    return this.loginForm.controls;
  }

  onSubmit(data: UserModel) {
    this.submitted = true;
    if (!this.loginForm.valid) {
      return;
    }
    if (data) {
      this.authService.login(data).pipe(
        tap(isUserValid => {
          if (isUserValid) {
            this.invalidUser = false;
            this.router.navigate(['/dashboard']);
          } else {
            this.invalidUser = true;
          }
        })
      ).subscribe();
    } else {
      this.invalidUser = true;
    }
  }
}
