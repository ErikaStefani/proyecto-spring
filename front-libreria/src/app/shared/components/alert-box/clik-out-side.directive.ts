import {
  Directive,
  EventEmitter,
  Output,
  ElementRef,
  HostListener,
} from "@angular/core";

@Directive({
  selector: "[clickOutside]",
})
export class ClickOutsideDirective {
  @Output() clickOutside = new EventEmitter();
  @Output() clickInside = new EventEmitter();
  constructor(private _elementRef: ElementRef) {}

  @HostListener("document:click", ["$event.target"])
  public onClick(targetElement) {
    const clickedInside =
      this._elementRef.nativeElement.contains(targetElement);
    if (!clickedInside) {
      this.clickOutside.emit(false);
    } else {
      this.clickInside.emit(true);
    }
  }
}
