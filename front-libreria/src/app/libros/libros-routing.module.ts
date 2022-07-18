import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../shared';
import { DetalleLibroComponent } from './detalle-libro/detalle-libro.component';
import { LibroComponent } from './libros.component';

const routes: Routes = [
  {
    path: '',
    component: LibroComponent,
    // canActivate: [AuthGuard]
  },
  {
    path: 'nuevo',
    component: DetalleLibroComponent,
    // canActivate: [AuthGuard]
  },
  {
    path: ':id',
    component: DetalleLibroComponent,
    // canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LibroRoutingModule { }
