import { trigger, animate, transition, style } from "@angular/animations";

export const slideInOutAnimation = trigger("slideInOutAnimation", [
  transition("* => true", [
    style({
      right: "-100%",
    }),
    animate(
      ".4s ease-in-out",
      style({
        right: 0,
      })
    ),
  ]),
  transition("* => false", [
    animate(
      ".5s ease-in-out",
      style({
        right: "-100%",
      })
    ),
  ]),
]);
