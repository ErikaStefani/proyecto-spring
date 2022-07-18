import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { NgbToastModule } from '@ng-bootstrap/ng-bootstrap';
import { AppToastsComponent } from './app-toast.component';

@NgModule({
    imports: [
      CommonModule, 
      RouterModule,
      NgbToastModule
    ],
    declarations: [AppToastsComponent],
    exports: [AppToastsComponent]
})
export class AppToastModule {}