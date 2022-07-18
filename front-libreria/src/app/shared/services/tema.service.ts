import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpService } from '../../core';
import { ApiEndpointService } from './';
import { TemaDto } from '../models/tema.model';

@Injectable({
  providedIn: 'root'
})
export class TemaService {
  constructor(
    private http: HttpService,
    private apiEndpointService: ApiEndpointService
  ) {
  }

  getTemas(): Observable<TemaDto[]> {
    return this.http.get<TemaDto[]>(
        this.apiEndpointService.getTemasEndpoint()
      );
  }
}
