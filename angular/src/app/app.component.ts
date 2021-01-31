import {Component, OnDestroy} from '@angular/core';
import {Subscription} from 'rxjs';
import {NavigationStart, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {AuthRefresh} from './auth/store/actions/auth.actions';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {
  title = 'MuRET';

  subscription: Subscription;

  constructor(private router: Router, store: Store<any>) {
    this.subscription = router.events.subscribe((event) => {
      if (event instanceof NavigationStart && !router.navigated) {
        // refresh page
        console.log('Refreshing');
        store.dispatch(new AuthRefresh());
      }
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
