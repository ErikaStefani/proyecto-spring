import { trigger, animate, transition, style } from "@angular/animations";

export const fadeInAnimation = trigger("fadeInAnimation", [
  transition("* => show", [
    style({ opacity: 0 }),
    animate(300, style({ opacity: 1 })),
  ]),
  transition("* => hide", [
    style({ opacity: 1 }),
    animate(300, style({ opacity: 0 })),
  ]),
]);
