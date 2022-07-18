import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpService } from '../../core';
import { ApiEndpointService } from './';
import { AutorDto } from '../models/autor.model';

@Injectable({
  providedIn: 'root'
})
export class AutorService {
  constructor(
    private http: HttpService,
    private apiEndpointService: ApiEndpointService
  ) {
  }

  getAutores(): Observable<AutorDto[]> {
    return this.http.get<AutorDto[]>(
        this.apiEndpointService.getAutorEndpoint()
      );
  }
}
