import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {selectDocumentAPIRestErrorSelector} from '../../../document/store/selectors/document.selector';
import {AdminDashboardState} from '../../store/state/admindb.state';
import {Store} from '@ngrx/store';
import {ShowErrorService} from '../../../../core/services/show-error.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit, OnDestroy {
  private serverErrorSubscription: Subscription;

  constructor(private store: Store<AdminDashboardState>, private showErrorService: ShowErrorService) {
  }

  ngOnInit() {
    this.serverErrorSubscription = this.store.select(selectDocumentAPIRestErrorSelector).subscribe(next => {
      if (next) {
        this.showErrorService.warning(next);
      }
    });

  }

  ngOnDestroy(): void {
    this.serverErrorSubscription.unsubscribe();
  }

}
