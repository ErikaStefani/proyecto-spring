import { NgModule } from '@angular/core';
import { TranslateModule } from '@ngx-translate/core';
import { SharedModule } from '../shared';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';

@NgModule({
  imports: [
    TranslateModule,
    LoginRoutingModule,
    SharedModule,
  ],
  declarations: [LoginComponent]
})
export class LoginModule { }
