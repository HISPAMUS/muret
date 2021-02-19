import {Component, OnDestroy, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray} from "@angular/cdk/drag-drop";
import {Subscription} from "rxjs";
import {DocumentState} from "../../store/state/document.state";
import {Store} from "@ngrx/store";
import {selectDocumentOverview} from "../../store/selectors/document.selector";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {DocumentGetOverview, DocumentReorderSections} from "../../store/actions/document.actions";
import {Section} from "../../../../core/model/entities/section";
import {compareOrdering} from "../../../../core/model/entities/iordered";
import {BreadcrumbsUpdateDocument} from "../../../../layout/store/actions/breadcrumbs.actions";
import {NumberArray} from "../../../../core/model/restapi/number-array";

@Component({
  selector: 'app-reorder-sections',
  templateUrl: './reorder-sections.component.html',
  styleUrls: ['./reorder-sections.component.css']
})
export class ReorderSectionsComponent implements OnInit, OnDestroy {
  documentOverviewSubscription: Subscription;
  sections: Section[];
  documentID: number;

  constructor(private store: Store<DocumentState>, private route: ActivatedRoute) {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.documentID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new DocumentGetOverview(this.documentID));
      this.store.dispatch(new BreadcrumbsUpdateDocument(this.documentID));
    });
  }

  ngOnInit(): void {
    this.documentOverviewSubscription = this.store.select(selectDocumentOverview).subscribe(next => {
      if (next) {
        this.sections = next.sections.slice().sort(compareOrdering); // must use slide to use a copy
      }
    });
  }

  drop(event: CdkDragDrop<Section[]>) {
    moveItemInArray(this.sections, event.previousIndex, event.currentIndex);
    // translate this ordering into the list of ids
    const ordering: NumberArray = {
      values: []
    }
    for (let i=0; i<this.sections.length; i++) {
      ordering.values.push(this.sections[i].id);
    }
    this.store.dispatch(new DocumentReorderSections(ordering));
  }

  ngOnDestroy(): void {
    this.documentOverviewSubscription.unsubscribe();
  }
}
