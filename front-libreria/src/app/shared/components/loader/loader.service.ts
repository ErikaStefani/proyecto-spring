import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoaderService {

  loader: boolean;
  private loaderResponse = new Subject<boolean>();

  constructor() { }

  showSpinner() {
    this.loaderResponse.next(true);
  }

  hideSpinner() {
    this.loaderResponse.next(false);
  }

  getRespLogin(): Observable<any> {
    return this.loaderResponse.asObservable();
  }
}
