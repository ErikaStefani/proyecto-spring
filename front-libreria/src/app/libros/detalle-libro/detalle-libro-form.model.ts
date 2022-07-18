import { AbstractControl, FormBuilder, FormGroup, Validators } from "@angular/forms";
import { LibroDto } from "../../shared/models/libro.model";

export interface DetalleLibroControls {
  id: AbstractControl;
  nombre: AbstractControl;
  autorId: AbstractControl;
  editorialId: AbstractControl;
  temaId: AbstractControl;
  materialId: AbstractControl;
  edad: AbstractControl;
  precio: AbstractControl;
  stockActual: AbstractControl;
  descripcion: AbstractControl;
}

export interface DetalleLibroModel {
  id: number;
  nombre: string;
  autorId: string;
  editorialId: string;
  temaId: string;
  materialId: string;
  edad: number;
  precio: number;
  stockActual: number;
  descripcion: string;
}

export class DetalleLibroFormHelper {
  static createForm(fb: FormBuilder, libro?: LibroDto, disabled = false) {
    return fb.group({
      id: [{ value: libro ? libro.id : null, disabled: disabled }],
      nombre: [{ value: libro ? libro.nombre : null, disabled: disabled }, Validators.required],
      autorId: [{ value: libro ? libro.autorId : null, disabled: disabled }, Validators.required],
      editorialId: [{ value: libro ? libro.editorialId : null, disabled: disabled }, Validators.required],
      temaId: [{ value: libro ? libro.temaId : null, disabled: disabled }, Validators.required],
      materialId: [{ value: libro ? libro.materialId : null, disabled: disabled }, Validators.required],
      edad: [{ value: libro ? libro.edad : null, disabled: disabled }, Validators.required],
      precio: [{ value: libro ? libro.precio : null, disabled: disabled }, Validators.required],
      stockActual: [{ value: libro ? libro.stockActual : null, disabled: disabled }],
      descripcion: [{ value: libro ? libro.descripcion : null, disabled: disabled }, Validators.required],
    });
  }

  static buildFormValues(receiptForm: FormGroup): DetalleLibroControls {
    return {
      id: receiptForm.get('id'),
      nombre: receiptForm.get('nombre'),
      autorId: receiptForm.get('autorId'),
      editorialId: receiptForm.get('editorialId'),
      temaId: receiptForm.get('temaId'),
      materialId: receiptForm.get('materialId'),
      edad: receiptForm.get('edad'),
      precio: receiptForm.get('precio'),
      stockActual: receiptForm.get('stockActual'),
      descripcion: receiptForm.get('descripcion'),
    };
  }
}