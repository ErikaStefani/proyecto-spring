import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { firstValueFrom, Observable, of, switchMap } from 'rxjs';

import { HttpService } from '../../core';
import { ApiEndpointService, AuthService } from './';
import { LibroDto } from '../models/libro.model';
import { DetalleLibroModel } from '../../libros/detalle-libro/detalle-libro-form.model';

@Injectable({
  providedIn: 'root'
})
export class LibroService {
  constructor(
    private http: HttpService,
    private apiEndpointService: ApiEndpointService,
    private authService: AuthService
  ) {
  }

  getLibros(): Observable<LibroDto[]> {
    return this.http.get<LibroDto[]>(
      this.apiEndpointService.getLibroEndpoint()
    );
  }

  registrarLibro(detalleLibroModel: DetalleLibroModel) {
    return this.http.post(this.apiEndpointService.getLibroEndpoint(), detalleLibroModel);
  }

  modificarLibro(detalleLibroModel: DetalleLibroModel) {
    return this.http.put(this.apiEndpointService.getLibroEndpoint() + `/${detalleLibroModel.id}`, detalleLibroModel);
  }

  eliminarLibro(id: string) {
    return this.http.delete(this.apiEndpointService.getLibroEndpoint() + `/${id}`);
  }

  getLibroById(id: string): Observable<LibroDto> {
    return this.http.get<LibroDto>(
      this.apiEndpointService.getLibroEndpoint() + `/${id}`
    );
  }
}
