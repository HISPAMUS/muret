import { Component, OnInit } from '@angular/core';
import {BreadcrumbLink} from '../../model/breadcrumb-link';
import {BreadcrumbsState} from '../../store/state/breadcrumbs.state';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {selectBreadcrumbsLinks} from '../../store/selectors/breadcrumbs.selector';
import {Router} from '@angular/router';

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css']
})
export class BreadcrumbComponent implements OnInit {
  links$: Observable<BreadcrumbLink[]>;

  constructor(protected store: Store<BreadcrumbsState>, private router: Router) { }

  ngOnInit() {
    this.links$ = this.store.select(selectBreadcrumbsLinks);
  }

  openLink(link: BreadcrumbLink) {
    if (link.routerLink) {
      this.router.navigate([link.routerLink]);
    } else if (link.href) {
        this.router.navigate(['/externalRedirect', { externalUrl: link.href }]);
    } else {
      throw new Error('Link without routerLink or href');
    }
  }

  trackLink(index, link) {
    return link.title;
  }
}
