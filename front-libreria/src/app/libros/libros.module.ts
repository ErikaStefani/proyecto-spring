import { NgModule } from '@angular/core';

import { DxDataGridModule, DxDateBoxModule, DxSelectBoxModule, DxTemplateModule, DxTextAreaModule, DxTextBoxModule, DxTooltipModule } from 'devextreme-angular';

import { SharedModule } from '../shared';
import { LibroComponent } from './libros.component';
import { LibroRoutingModule } from './libros-routing.module';
import { DetalleLibroComponent } from './detalle-libro/detalle-libro.component';
import { TranslateModule } from '@ngx-translate/core';

@NgModule({
  declarations: [
    LibroComponent,
    DetalleLibroComponent
  ],
  imports: [
    SharedModule,
    LibroRoutingModule,
    DxDataGridModule,
    DxTextBoxModule,
    DxDateBoxModule,
    DxTooltipModule,
    DxTemplateModule,
    DxTextAreaModule,
    DxSelectBoxModule,
    TranslateModule
  ]
})
export class LibroModule { }
