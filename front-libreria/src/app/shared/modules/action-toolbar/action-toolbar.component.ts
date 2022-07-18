import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
    selector: 'app-action-toolbar',
    templateUrl: './action-toolbar.component.html',
    styleUrls: ['./action-toolbar.component.scss']
})
export class ActionToolbarComponent implements OnInit {

    @Input() title: string;
    @Input() titleAddon: string;
    @Input() backRouterLink: string;
    @Input() queryParams: any = {};
    @Input() showBackButton = true;

    @Output() acccepClick = new EventEmitter();

    constructor() {}

    ngOnInit() {}

    acceptButtonClick(){
      this.acccepClick.emit();
    }
}
