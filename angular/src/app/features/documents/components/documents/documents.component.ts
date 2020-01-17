import {Component, OnDestroy, OnInit, Self} from '@angular/core';
import {Document} from '../../../../core/model/entities/document';
import {Permissions} from '../../../../core/model/entities/permissions';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {Collection} from '../../../../core/model/entities/collection';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {GetCollection} from '../../store/actions/documents.actions';
import {selectCollection} from '../../store/selectors/documents.selector';

@Component({
  selector: 'app-documents',
  templateUrl: './documents.component.html',
  styleUrls: ['./documents.component.css'],
})

export class DocumentsComponent implements OnInit, OnDestroy {
  collection$: Observable<Collection>;
  collectionID: number;

  constructor(private route: ActivatedRoute, private store: Store<any>) {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.collectionID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new GetCollection(this.collectionID));
    });

    this.collection$ = store.select(selectCollection);
  }

  ngOnInit(): void {
  }

  trackByDocumentFn(index, item: Document) {
    return item.id; // unique id corresponding to the item
  }

  trackByPermissionFn(index, item: Permissions) {
    return item.id; // unique id corresponding to the item
  }


  ngOnDestroy(): void {
  }
}
