import { Component, Input } from '@angular/core';

@Component({
  selector: 'collapsible-card',
  templateUrl: './colapsible-card.component.html',
  styleUrls: ['./colapsible-card.component.scss']
})
export class CollapsibleCardComponent {
  @Input() collapsed: boolean = true;
  @Input() title: string;
}