import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DxDataGridComponent } from 'devextreme-angular';
import ArrayStore from 'devextreme/data/array_store';
import DataSource from 'devextreme/data/data_source';
import { exportDataGrid } from 'devextreme/excel_exporter';
import { Workbook } from 'exceljs';
import { saveAs } from 'file-saver';
import { slideToTop } from '../router.animations';
import { AppToastService, MaskFormatHelper } from '../shared';
import { LibroDto } from '../shared/models/libro.model';
import { LibroService } from '../shared/services/libro.service';

@Component({
  selector: 'app-libro',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.scss'],
  animations: [slideToTop()]
})
export class LibroComponent implements OnInit {

  @ViewChild(DxDataGridComponent, { static: false }) dataGrid: DxDataGridComponent;
  @ViewChild("confirmationModal", { static: false }) confirmationModal: ElementRef;
  dataSource: DataSource;
  searchText: string;
  libros: LibroDto[];
  title = "Libros"

  partNoFormat = MaskFormatHelper.partNoFormat;

  constructor(
    public libroService: LibroService,
    private router: Router,
    private modalService: NgbModal,
    private appToastService: AppToastService,
  ) {

  }

  ngOnInit(): void {
    this.obtenerLibros();
  }

  onExporting(e) {
    const workbook = new Workbook();
    const worksheet = workbook.addWorksheet('Libros');

    exportDataGrid({
      component: e.component,
      worksheet,
      autoFilterEnabled: true,
    }).then(() => {
      workbook.xlsx.writeBuffer().then((buffer) => {
        saveAs(new Blob([buffer], { type: 'application/octet-stream' }), 'stock-information.xlsx');
      });
    });
    e.cancel = true;
  }

  exportToExcel() {
    const workbook = new Workbook();
    const worksheet = workbook.addWorksheet('Libros');

    exportDataGrid({
      component: this.dataGrid.instance,
      worksheet,
      autoFilterEnabled: true,
    }).then(() => {
      workbook.xlsx.writeBuffer().then((buffer) => {
        saveAs(new Blob([buffer], { type: 'application/octet-stream' }), 'stock-information.xlsx');
      });
    });
  }

  agregarLibro() {
    this.router.navigate(['/libros/nuevo']);
  }

  editarLibro() {
    const selectedRowsData = this.dataGrid.instance.getSelectedRowsData();
    if (selectedRowsData && selectedRowsData.length) {
      this.router.navigate(['/libros', selectedRowsData[0].id]);
    } else {
      this.appToastService.showWarning('Debe seleccionar una fila');
    }
  }

  eliminarLibro() {
    const selectedRowsData = this.dataGrid.instance.getSelectedRowsData();
    if (selectedRowsData && selectedRowsData.length) {
      this.modalService.open(this.confirmationModal, { ariaLabelledBy: 'modal-basic-title', centered: true })
      .result.then((result) => {
        this.libroService.eliminarLibro(selectedRowsData[0].id)
        .subscribe(() => {
          this.obtenerLibros();
        });
      }, (reason) => {});
    } else {
      this.appToastService.showWarning('Debe seleccionar una fila');
    }
  }

  onRowDblClick(e: any) {
    if (e && e.data) {
      this.router.navigate(['/libros', e.data.id]);
    }
  }

  search(e) {
    if (this.searchText) {
      this.dataSource.reload();
    }
  }

  private obtenerLibros() {
    return this.libroService.getLibros()
      .subscribe(libros => {
        this.libros = libros;
        this.createLibroDatasource();
      });
  }

  private createLibroDatasource() {
    const libroStore = new ArrayStore({
      data: this.libros
    });
    this.dataSource = new DataSource({
      store: libroStore
    });
  }
}
