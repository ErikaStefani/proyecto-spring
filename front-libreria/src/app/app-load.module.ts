import { NgModule, APP_INITIALIZER } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import dxDataGrid from "devextreme/ui/data_grid";
import { AppConfigService } from './core';

@NgModule({
  imports: [
    HttpClientModule
  ],
  providers: [
    AppConfigService,
    {
      provide: APP_INITIALIZER,
      multi: true,
      deps: [AppConfigService],
      useFactory: (appConfigService: AppConfigService) => {
        return () => {
          //Make sure to return a promise!
          return appConfigService.loadAppConfig();
        };
      }
    },
    {
      provide: APP_INITIALIZER,
      multi: true,
      deps: [AppConfigService],
      useFactory: () => {
        return () => {
          //Make sure to return a promise!
          return new Promise<void>((resolve, reject) => {
            dxDataGrid.defaultOptions({
              device: { deviceType: 'desktop' },
              options: {
                noDataText: 'No records found',
                columnAutoWidth: true,
                showColumnLines: true,
                showRowLines: true,
                showBorders: true,
                wordWrapEnabled: false,
                hoverStateEnabled: true,
                rowAlternationEnabled: true,
                allowColumnResizing: true,
                loadPanel: {
                  enabled: true,
                  height: 90,
                  indicatorSrc: '',
                  shading: false,
                  shadingColor: '',
                  showIndicator: true,
                  showPane: true,
                  text: 'Loading...',
                  width: 200
                },
                selection: {
                  mode: "single"
                },
                scrolling: {
                  rowRenderingMode: "virtual"
                },
                paging:{
                  pageSize: 15
                },
                pager: {
                  visible: true,
                  allowedPageSizes: [15, 50, 100],
                  displayMode: 'full',
                  showPageSizeSelector: true,
                  showInfo: true,
                  showNavigationButtons: true
                }
              }
            });
            resolve();
          });
        };
      }
    }
  ]
})
export class InventoryWebLoadModule { }
