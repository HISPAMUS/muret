import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {ClearLinks} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private store: Store<any>) {
    store.dispatch(new ClearLinks());
  }

  ngOnInit() {
  }

}
