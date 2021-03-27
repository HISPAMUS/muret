import { Component, OnInit } from '@angular/core';
import {BreadcrumbsState} from "../../store/state/breadcrumbs.state";
import {Store} from "@ngrx/store";
import {BreadcrumbsClear} from "../../store/actions/breadcrumbs.actions";
import {Router} from "@angular/router";

@Component({
  selector: 'app-hamburguer-menu',
  templateUrl: './hamburguer-menu.component.html',
  styleUrls: ['./hamburguer-menu.component.css']
})
export class HamburguerMenuComponent implements OnInit {
  isMenuCollapsed = true;

  constructor(public router: Router, private store: Store<BreadcrumbsState>) { }

  ngOnInit(): void {
  }

  goHome() {
    this.store.dispatch(new BreadcrumbsClear());
    this.router.navigate(['/home']);
  }
}
