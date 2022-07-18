import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { tap } from 'rxjs';
import { slideToTop } from '../../router.animations';
import { AppToastService, FileUtils, shouldShowErrors } from '../../shared';
import { DetalleLibroControls, DetalleLibroFormHelper, DetalleLibroModel } from './detalle-libro-form.model';
import { LibroService } from '../../shared/services/libro.service';
import { LibroDto } from '../../shared/models/libro.model';
import { AutorService } from '../../shared/services/autor.service';
import { AutorDto } from '../../shared/models/autor.model';
import { EditorialService } from '../../shared/services/editorial.service';
import { EditorialDto } from '../../shared/models/editorial.model';
import { TemaService } from '../../shared/services/tema.service';
import { MaterialService } from '../../shared/services/material.service';
import { TemaDto } from '../../shared/models/tema.model';
import * as saveAs from 'file-saver';
import { MaterialDto } from '../../shared/models/material.model';

@Component({
  selector: 'app-detalle-libro',
  templateUrl: './detalle-libro.component.html',
  styleUrls: ['./detalle-libro.component.scss'],
  animations: [slideToTop()]
})
export class DetalleLibroComponent implements OnInit {

  detalleLibroForm: FormGroup;
  controls: DetalleLibroControls;
  shouldShowErrors = shouldShowErrors;
  title = 'Registrar Libro ';
  detalleLibro: LibroDto;
  id: string;
  autores: AutorDto[];
  editoriales: EditorialDto[];
  temas: TemaDto[];
  materiales : MaterialDto[];

  constructor(
    private libroService: LibroService,
    private autorService: AutorService,
    private editorialService: EditorialService,
    private temaService: TemaService,
    private materialService:MaterialService,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private appToastService: AppToastService,
    private router: Router
  ) {

  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.createForm();
    this.obtenerAutores();
    this.obtenerEditoriales();
    this.obtenerTemas();
    this.obtenerMateriales();

    if (this.id) {
      this.title = 'Actualizar Libro: ';
      this.libroService.getLibroById(this.id)
        .pipe(
          tap(data => {
            this.loadData(data);
            this.createForm();
          })
        ).subscribe();
    } else {
      this.detalleLibroForm.enable();
    }
  }

  guardarLibro() {
    if (!this.detalleLibroForm.valid) {
      this.appToastService.showWarning('Complete todos los datos');
    }
    const libroModel = this.detalleLibroForm.getRawValue() as DetalleLibroModel;
    if(this.id){
      this.libroService.modificarLibro(libroModel)
      .subscribe(result => {
        this.router.navigate(['libros']);
      });
    } else{
      this.libroService.registrarLibro(libroModel)
      .subscribe(result => {
        this.router.navigate(['libros']);
      });
    }
  }

  downloadFile(data: any) {
    if (data) {
      var blob = FileUtils.base64ToBlob(data.content, data.mimeType);
      saveAs(blob, data.name);
    }
  }

  private createForm() {
    this.detalleLibroForm = DetalleLibroFormHelper.createForm(this.fb, this.detalleLibro);
    this.controls = DetalleLibroFormHelper.buildFormValues(this.detalleLibroForm);
  }

  private loadData(libroDto: LibroDto) {
    this.detalleLibro = libroDto;
  }

  private obtenerAutores() {
    return this.autorService.getAutores()
      .subscribe(autores => {
        this.autores = autores;
      });
  }

  private obtenerEditoriales() {
    return this.editorialService.getEditoriales()
      .subscribe(editoriales => {
        this.editoriales = editoriales;
      });
  }

  private obtenerTemas() {
    return this.temaService.getTemas()
      .subscribe(temas => {
        this.temas = temas;
      });
  }
  private obtenerMateriales(){
    return this.materialService.getMateriales()
      .subscribe(materiales => {
        this.materiales = materiales;
      });
  }
}
