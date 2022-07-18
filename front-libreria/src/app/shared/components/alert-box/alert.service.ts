import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlertService {
  isVisible: boolean;
  messageAuth: string;
  titleAlert: string;
  typeAlert: string;

  constructor() {
  }

  errorAlert(message) {
    this.typeAlert = "error"
    this.messageAuth = message;
    this.isVisible = true
  }

  warningAlert(message) {
    this.messageAuth = message;
    this.isVisible = true
    this.typeAlert = "warning"
  }

  successAlert(message) {
    this.messageAuth = message;
    this.isVisible = true
    this.typeAlert = "success"
  }
  closeMessage() {
    this.isVisible = false
  }
}
