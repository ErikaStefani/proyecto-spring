import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ActionToolbarComponent } from './action-toolbar.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [
    ActionToolbarComponent
  ],
  exports: [
    ActionToolbarComponent
  ]
})
export class ActionToolbarModule { }
