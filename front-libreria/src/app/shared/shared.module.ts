import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DxNumberBoxModule } from 'devextreme-angular';
import { PageHeaderModule } from './modules';
import { AppToastModule } from './modules/toast/app-toast.module';
import { LoaderComponent } from './components/loader/loader.component';
import { AlertBoxComponent } from './components/alert-box/alert-box.component';
import { ClickOutsideDirective } from './components/alert-box/clik-out-side.directive';
import { ColapsibleCardModule } from './components/colapsible-card/colapsible-card.module';
import { ActionToolbarModule } from './modules/action-toolbar/action-toolbar.module';
import { DebounceClickDirective } from './directives/debounce-click.directive';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    LoaderComponent, 
    AlertBoxComponent, 
    ClickOutsideDirective,
    DebounceClickDirective
  ],
  exports:[
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    AppToastModule,
    PageHeaderModule,
    LoaderComponent,
    AlertBoxComponent,
    ClickOutsideDirective,
    ColapsibleCardModule,
    ActionToolbarModule,
    DxNumberBoxModule,
    DebounceClickDirective
  ]
})
export class SharedModule { }