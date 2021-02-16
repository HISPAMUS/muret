import { Component, OnInit } from '@angular/core';
import {BreadcrumbsState} from '../../store/state/breadcrumbs.state';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {selectBreadcrumbs} from '../../store/selectors/breadcrumbs.selector';
import {Router} from '@angular/router';
import {Breadcrumb} from "../../../core/model/restapi/breadcrumb";
import {logger} from "codelyzer/util/logger";

@Component({
  selector: 'app-breadcrumbs',
  templateUrl: './breadcrumbs.component.html',
  styleUrls: ['./breadcrumbs.component.css']
})
export class BreadcrumbsComponent implements OnInit {
  breadcrumbs$: Observable<Breadcrumb[]>;

  constructor(protected store: Store<BreadcrumbsState>, private router: Router) { }

  ngOnInit() {
    this.breadcrumbs$ = this.store.select(selectBreadcrumbs);
  }

  openLink(link: Breadcrumb) {
    if (link.breadcrumbType === 'collection') {
      this.router.navigate(['/documents', link.id]);
    } else if (link.breadcrumbType === 'document') {
      this.router.navigate(['/document', link.id]);
    } else if (link.breadcrumbType === 'image') {
      this.router.navigate(['/imageRecognition/overview', link.id]);
    } else {
      throw new Error('Link not valid with breadcrumb type: ' + link.breadcrumbType);
    }
  }

  trackBreadcrumb(index, item) {
    return index;
  }

  getClass(isLast: boolean): string | string[] {
    if (isLast) {
      return ["breadcrumb-item", "active"];
    } else {
      return ["breadcrumb-item"];
    }
  }
}
