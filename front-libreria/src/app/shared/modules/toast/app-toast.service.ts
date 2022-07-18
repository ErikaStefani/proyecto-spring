import { Injectable } from "@angular/core";

export interface ToastInfo {
  header: string;
  body: string;
  delay?: number;
  classname?: string;
}

@Injectable({ providedIn: 'root' })
export class AppToastService {
  toasts: ToastInfo[] = [];

  showSucess(body: string, header?: string, delay?: number) {
    this.toasts.push({ header, body, classname: 'bg-success text-light' });
  }

  showError(body: string, header?: string, delay?: number) {
    this.toasts.push({ header, body, classname: 'bg-danger text-light' });
  }

  showWarning(body: string, header?: string, delay?: number) {
    this.toasts.push({ header, body, classname: 'bg-warning text-dark' });
  }

  remove(toast: ToastInfo) {
    this.toasts = this.toasts.filter(t => t != toast);
  }
}