import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams, HttpBackend } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { CoreModule } from '../core.module';

@Injectable({
  providedIn: CoreModule
})
export class HttpService {

  private httpWithoutInterceptor: HttpClient;

  constructor(
    private http: HttpClient,
    private httpBackend: HttpBackend
  ) {
    this.httpWithoutInterceptor = new HttpClient(httpBackend);
  }

  private formatErrors(error: any) {
    return throwError(error.error);
  }

  get<T>(path: string, params: HttpParams = new HttpParams(), headers = new HttpHeaders()): Observable<T> {
    return this.http.get<T>(`${path}`, { params })
      .pipe(catchError(this.formatErrors));
  }

  put(path: string, body: Object = {}): Observable<any> {
    return this.http.put(
      `${path}`,
      body
    ).pipe(catchError(this.formatErrors));
  }

  post<T>(path: string, body: Object = {}, options: Object = {}): Observable<T> {
    return this.http.post<T>(`${path}`, body, options)
      .pipe(catchError(this.formatErrors));
  }

  delete(path): Observable<any> {
    return this.http.delete(
      `${path}`
    ).pipe(catchError(this.formatErrors));
  }

  _get<T>(path: string, params: HttpParams = new HttpParams()): Observable<T> {
    return this.httpWithoutInterceptor.get<T>(`${path}`, { params })
      .pipe(catchError(this.formatErrors));
  }

  _put(path: string, body: Object = {}): Observable<any> {
    return this.httpWithoutInterceptor.put(
      `${path}`,
      JSON.stringify(body)
    ).pipe(catchError(this.formatErrors));
  }

  _post<T>(path: string, body: Object = {}, options: Object = {}): Observable<T> {
    return this.httpWithoutInterceptor.post<T>(`${path}`, body, options)
      .pipe(catchError(this.formatErrors));
  }

  _delete(path): Observable<any> {
    return this.httpWithoutInterceptor.delete(
      `${path}`
    ).pipe(catchError(this.formatErrors));
  }
}