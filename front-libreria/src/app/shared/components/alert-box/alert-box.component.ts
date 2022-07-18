import { Component, OnInit, Input, Output, EventEmitter } from "@angular/core";
import { fadeInAnimation } from "../../animations/fade-in.animation";
import { slideInOutAnimation } from "../../animations/slide-in-out.animation";
import { AlertService } from "./alert.service";

@Component({
  selector: "alert-box",
  templateUrl: "./alert-box.component.html",
  styleUrls: ["./alert-box.component.scss"],
  animations: [fadeInAnimation, slideInOutAnimation],
})
export class AlertBoxComponent implements OnInit {
  @Input() visible;
  @Input() type;
  @Input() title;
  @Input() notifyMessage;
  @Output() isVisible = new EventEmitter();
  className: string;

  constructor(private alertService: AlertService) { }

  ngOnInit() {
    this.visible = true;
    switch (this.type) {
      case "error":
        this.className = "alert-container-error";
        break;
      case "warning":
        this.className = "alert-warning";
        break;
      case "success":
        this.className = "alert-success";
        break;
      default:
        this.className = "alert-warning";
        break;
    }
  }

  closeMessage() {
    // this.currentState = "hide";
    this.visible = false;
    this.isVisible.emit(this.visible);
  }

  getDisplay(): string {
    return this.visible ? "inherit" : "none";
  }

  clickOut() {
    this.closeMessage()
  }
}
