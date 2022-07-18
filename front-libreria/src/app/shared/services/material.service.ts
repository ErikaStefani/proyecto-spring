import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpService } from '../../core';
import { ApiEndpointService } from './';
import { MaterialDto } from '../models/material.model';

@Injectable({
  providedIn: 'root'
})
export class MaterialService {
  constructor(
    private http: HttpService,
    private apiEndpointService: ApiEndpointService
  ) {
  }

  getMateriales(): Observable<MaterialDto[]> {
    return this.http.get<MaterialDto[]>(
        this.apiEndpointService.getMaterialesEndpoint()
      );
  }
}
