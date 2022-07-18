import { AbstractControl, FormControl, FormGroup } from "@angular/forms";

export class ErrorControlMessage {
  public static readonly errorMessages = {
    required: params => params.message ? params.message : 'The field is required',
    minlength: params => 'El número de caracteres mínimo es ' + params.requiredLength,
    maxlength: params => 'El número de caracteres máximo es ' + params.requiredLength,
    min: params => 'El número mínimo es ' + params.min,
    max: params => 'El número máximo es ' + params.max,
    pattern: params => 'El patrón requerido es ' + params.pattern,
    custom: params => params.message,
    nonWorkingDay: params => params.message,
    range: params => 'El número debe estar comprendido entre ' + params.min + ' y ' + params.max,
    customMin: min => 'El número mínimo es ' + min,
    errorDate: params => 'Rango inválido',
    minAmount: min => 'El monto ingresado no alcanza el mínimo requerido',
    maxAmount: max => 'El monto ingresado requiere autorización',
    uniqueNumber: uniqueNumber => 'El número de cheque ingresado fue previamente cargado',
    uniqueNumberAsync: uniqueNumberAsync => 'El número de cheque ingresado ya fue cargado en el sistema',
    invalidCreditCard: params => 'El número ingresado es inválido'
  };
}

export function shouldShowErrors(controls: AbstractControl[], checkDirtyState: boolean = true): boolean {
  let error = false;
  controls.forEach(e => {
    if (e.invalid && (!checkDirtyState || (checkDirtyState && (e.dirty && e.touched)))) {
      error = true;
    }
  });
  return error;
}

export function getAllMessage(controls: AbstractControl[]): any {
  let stringError = '';
  controls.forEach(control => {
    if (control && control.errors) {
      Object.keys(control.errors).forEach(field => {
        const e = ErrorControlMessage.errorMessages[field](
          control.errors[field]
        );
        stringError = stringError + e + '<br>';
      });
    }
  });

  return { message: stringError };
}

export function validateAllFormFields(formGroup: FormGroup) {
  Object.keys(formGroup.controls).forEach(field => {
    const control = formGroup.get(field);
    if (control instanceof FormControl) {
      control.markAsTouched({ onlySelf: true });
      control.markAsDirty({ onlySelf: true });
    } else if (control instanceof FormGroup) {
      this.validateAllFormFields(control);
    }
  });
}