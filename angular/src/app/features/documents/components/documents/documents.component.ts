import {Component, OnDestroy, OnInit, Self} from '@angular/core';
import {Document} from '../../../../core/model/entities/document';
import {Permissions} from '../../../../core/model/entities/permissions';
import {Subscription} from 'rxjs';
import {Store} from '@ngrx/store';
import {Collection} from '../../../../core/model/entities/collection';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {
  DocumentsCreateSubcollection,
  DocumentsDeleteSubcollection,
  DocumentsGetCollection,
  DocumentsMoveDocumentsToNewSubcollection, DocumentsMoveDocumentsToSubcollection, DocumentsResetDocumentsServerError
} from '../../store/actions/documents.actions';
import {selectDocumentsChangedCollectionID, selectDocumentsCollection, selectDocumentsServerError} from '../../store/selectors/documents.selector';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {ModalOptions} from '../../../../dialogs/options-dialog/options-dialog.component';
import {ShowErrorService} from '../../../../core/services/show-error.service';
import {BreadcrumbsUpdateCollection} from "../../../../layout/store/actions/breadcrumbs.actions";


@Component({
  selector: 'app-documents',
  templateUrl: './documents.component.html',
  styleUrls: ['./documents.component.css'],
})

export class DocumentsComponent implements OnInit, OnDestroy {
  collectionID: number;
  selectedDocumentsIds: Array<number>;
  collection: Collection;
  collectionSubscription: Subscription;
  changedCollectionIDSubscription: Subscription;
  private serverErrorSubscription: Subscription;

  constructor(private route: ActivatedRoute, private store: Store<any>, private dialogsService: DialogsService,
              private showErrorService: ShowErrorService) {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.collectionID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new DocumentsGetCollection(this.collectionID));
      this.store.dispatch(new BreadcrumbsUpdateCollection(this.collectionID));
    });
  }

  ngOnInit(): void {
    this.selectedDocumentsIds = new Array<number>();
    this.collectionSubscription = this.store.select(selectDocumentsCollection).subscribe(next => {
      this.collection = next;
      /*setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        if (this.collection) {
          this.store.dispatch(new ActivateLink(LinkType.Collection, {
            title: this.collection.name,
            routerLink: 'documents/' + this.collectionID
          }));
        }
      });*/
    });
    this.changedCollectionIDSubscription = this.store.select(selectDocumentsChangedCollectionID).subscribe(next => {
      if (next) {
        // reload it
        this.collectionID = next;
        this.store.dispatch(new DocumentsGetCollection(next));
      }
    });
    this.serverErrorSubscription = this.store.select(selectDocumentsServerError).subscribe(next => {
      if (next) {
        this.showErrorService.showServerError(next);
        this.store.dispatch(new DocumentsResetDocumentsServerError());
      }
    });
  }

  trackBySubcollectionFn(index, item: Collection) {
    return item.id; // unique id corresponding to the item
  }

  trackByDocumentFn(index, item: Document) {
    return item.id; // unique id corresponding to the item
  }

  trackByPermissionFn(index, item: Permissions) {
    return item.id; // unique id corresponding to the item
  }


  ngOnDestroy(): void {
    this.collectionSubscription.unsubscribe();
    this.changedCollectionIDSubscription.unsubscribe();
    this.serverErrorSubscription.unsubscribe();
  }

  addSubcollection() {
    this.dialogsService.showInput('Subcollections', 'Add subcollection', '')
      .subscribe((text) => {
        if (text) {
          this.store.dispatch(new DocumentsCreateSubcollection(this.collectionID, text.trim()));
        }
      });
  }

  deleteSubcollection(id: number) {
    this.dialogsService.showConfirmation('Delete subcollection?', 'This action will delete subcollection and cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.store.dispatch(new DocumentsDeleteSubcollection(id));
        }
      });
  }

  canBeDeleted(subcollection: Collection) {
    return !subcollection.documents || subcollection.documents.length === 0 && subcollection.subcollections.length === 0;
  }

  moveToSubcollection() {
    if (this.selectedDocumentsIds.length === 0) {
      this.dialogsService.showWarningConfirmation('Collections', 'No document is selected to be moved');
    } else {
      const options: ModalOptions[] = [];
      if (this.collection.parentId) {
        const item: ModalOptions = {
          id: '' + this.collection.parentId,
          name: 'Parent collection'
        };
        options.push(item);
      }
      this.collection.subcollections.forEach(subcol => {
        const item: ModalOptions = {
          id: '' + subcol.id,
          name: subcol.name,
        };
        options.push(item);
      });

      this.dialogsService.showOptions('Move documents to collection', options, 'New subcollection').subscribe(result => {
        if (result) {
          if (!result.id) {
            this.store.dispatch(new DocumentsMoveDocumentsToNewSubcollection(this.collection.id, this.selectedDocumentsIds, result.name));
          } else {
            this.store.dispatch(new DocumentsMoveDocumentsToSubcollection(this.collection.id, this.selectedDocumentsIds, +result.id));
          }
        }
      });
    }
  }

  onDocumentSelectionChanged(e: Event) {
    const checkbox = e.target as HTMLInputElement;
    const id = +checkbox.id;
    if (checkbox.checked) {
      this.selectedDocumentsIds.push(id);
    } else {
      this.selectedDocumentsIds.push(id);
    }
  }
}
