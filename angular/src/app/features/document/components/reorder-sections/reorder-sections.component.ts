import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray} from "@angular/cdk/drag-drop";
import {Observable, Subscription} from "rxjs";
import {DocumentState} from "../../store/state/document.state";
import {Store} from "@ngrx/store";
import {selectDocumentOverview} from "../../store/selectors/document.selector";
import {Document} from "../../../../core/model/entities/document";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {DocumentGetOverview, DocumentReorderSections} from "../../store/actions/document.actions";
import {compare, Section} from "../../../../core/model/entities/section";
import {Ordering} from "../../../../core/model/restapi/ordering";

@Component({
  selector: 'app-reorder-sections',
  templateUrl: './reorder-sections.component.html',
  styleUrls: ['./reorder-sections.component.css']
})
export class ReorderSectionsComponent implements OnInit, OnDestroy {
  documentOverviewSubscription: Subscription;
  sections: Section[];
  private documentID: number;

  constructor(private store: Store<DocumentState>, private route: ActivatedRoute) {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.documentID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new DocumentGetOverview(this.documentID));
    });
  }

  ngOnInit(): void {
    this.documentOverviewSubscription = this.store.select(selectDocumentOverview).subscribe(next => {
      if (next) {
        this.sections = next.sections.slice().sort(compare); // must use slide to use a copy
      }
    });
  }

  drop(event: CdkDragDrop<Section[]>) {
    moveItemInArray(this.sections, event.previousIndex, event.currentIndex);
    // translate this ordering into the list of ids
    const ordering: Ordering = {
      idsSequence: []
    }
    for (let i=0; i<this.sections.length; i++) {
      ordering.idsSequence.push(this.sections[i].id);
    }
    this.store.dispatch(new DocumentReorderSections(ordering));
  }

  ngOnDestroy(): void {
    this.documentOverviewSubscription.unsubscribe();
  }
}
