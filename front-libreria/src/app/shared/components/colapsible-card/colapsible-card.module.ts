import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { NgbCollapseModule } from '@ng-bootstrap/ng-bootstrap';
import { TranslateModule } from '@ngx-translate/core';
import { CollapsibleCardComponent } from './colapsible-card.component';

@NgModule({
  imports: [
    CommonModule,
    TranslateModule,
    NgbCollapseModule
  ],
  declarations: [
    CollapsibleCardComponent
  ],
  exports:[
    CollapsibleCardComponent
  ]
})
export class ColapsibleCardModule { }
