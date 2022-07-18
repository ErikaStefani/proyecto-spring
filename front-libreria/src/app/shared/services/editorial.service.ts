import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpService } from '../../core';
import { ApiEndpointService } from './';
import { EditorialDto } from '../models/editorial.model';

@Injectable({
  providedIn: 'root'
})
export class EditorialService {
  constructor(
    private http: HttpService,
    private apiEndpointService: ApiEndpointService
  ) {
  }

  getEditoriales(): Observable<EditorialDto[]> {
    return this.http.get<EditorialDto[]>(
        this.apiEndpointService.getEditorialEndpoint()
      );
  }
}
