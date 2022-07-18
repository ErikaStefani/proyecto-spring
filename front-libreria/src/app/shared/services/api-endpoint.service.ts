import { Injectable } from '@angular/core';
import { UrlBuilder } from '../utils/url-builder';
import { QueryStringParameters } from '../utils/query-string-parameters';
import { AppConfigService } from '../../core';

@Injectable({
  providedIn: 'root'
})
export class ApiEndpointService {
  constructor(private appConfigService: AppConfigService) { }

  private createUrl(action: string, isMockAPI: boolean = false): string {
    const urlBuilder: UrlBuilder = new UrlBuilder(
      isMockAPI ? this.appConfigService.apiMockUrl :
        this.appConfigService.apiBaseUrl,
      action
    );
    return urlBuilder.toString();
  }

  private createUrlWithQueryParameters(action: string,
    queryStringHandler?: (queryStringParameters: QueryStringParameters) => void
  ): string {
    const urlBuilder: UrlBuilder = new UrlBuilder(
      this.appConfigService.apiBaseUrl,
      action
    );
    // Push extra query string params
    if (queryStringHandler) {
      queryStringHandler(urlBuilder.queryString);
    }
    return urlBuilder.toString();
  }

  private createUrlWithPathVariables(action: string, pathVariables: any[] = []): string {
    let encodedPathVariablesUrl: string = '';
    // Push extra path variables
    for (const pathVariable of pathVariables) {
      if (pathVariable !== null) {
        encodedPathVariablesUrl +=
          `/${encodeURIComponent(pathVariable.toString())}`;
      }
    }
    const urlBuilder: UrlBuilder = new UrlBuilder(
      this.appConfigService.apiBaseUrl,
      `${action}${encodedPathVariablesUrl}`
    );
    return urlBuilder.toString();
  }

  public getAutenticarEndpoint(): string {
    return this.createUrl('api/autenticar');
  }

  public getLibroEndpoint(id=''): string {
    return this.createUrl('api/libros');
  }

  public getAutorEndpoint(): string {
    return this.createUrl('api/autores');
  }

  public getEditorialEndpoint(): string {
    return this.createUrl('api/editoriales');
  }

  public getTemasEndpoint(): string {
    return this.createUrl('api/temas');
  }
  public getMaterialesEndpoint(): string {
    return this.createUrl('api/materiales');
  }
}