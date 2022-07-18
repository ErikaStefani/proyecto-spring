import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { CoreModule } from '../core.module';
import { AppConfig } from './app-config.model';

@Injectable({
  providedIn: CoreModule
})
export class AppConfigService {

  private appConfig: AppConfig;

  constructor(private http: HttpClient) { }

  loadAppConfig(): Observable<AppConfig> {
    return this.http.get<AppConfig>('/assets/config.json')
      .pipe(
        tap(data => {
          this.appConfig = data;
        })
      );
  }

  get apiBaseUrl() {

    if (!this.appConfig) {
      throw Error('Config file not loaded!');
    }

    return this.appConfig.apiEndpoint;
  }

  get tenantId() {

    if (!this.appConfig) {
      throw Error('Config file not loaded!');
    }

    return this.appConfig.tenantId;
  }

  get apiKey() {
    if (!this.appConfig) {
      throw Error('Config file not loaded!');
    }

    return this.appConfig.apiKey;
  }

  get apiMockUrl() {
    if (!this.appConfig) {
      throw Error('Config file not loaded!');
    }

    return this.appConfig.apiMockEndpoint;
  }
}