import { Component, OnDestroy } from '@angular/core';
import { Subject, Subscription, takeUntil } from 'rxjs';
import { AlertService } from './shared/components/alert-box/alert.service';
import { LoaderService } from './shared/components/loader/loader.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnDestroy {
  loader: boolean;
  private destroy = new Subject<boolean>();

  constructor(
    // public alertService: AlertService,
    private loaderService: LoaderService
  ) {
    this.loaderService.getRespLogin()
      .pipe(
        takeUntil(this.destroy)
      )
      .subscribe(status => {
        this.loader = status;
      })
  }

  ngOnDestroy(): void {
    this.destroy.next(true);
  }
}
