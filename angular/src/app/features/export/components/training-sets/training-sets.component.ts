import {Component, OnDestroy, OnInit} from '@angular/core';
import saveAs from 'file-saver';
import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';
import {Document} from '../../../../core/model/entities/document';
import {Permissions} from '../../../../core/model/entities/permissions';
import {ExporterService} from '../../services/exporter.service';
import {Store} from '@ngrx/store';
import {Observable, Subscription} from 'rxjs';
import {DownloadTrainingSet, GetTrainingSetExporters, ResetExportServerError} from '../../store/actions/export.actions';
import {GetUser} from '../../../../core/store/actions/user.actions';
import {selectAuthState} from '../../../../auth/store/selectors/auth.selector';
import {selectLoggedInUser} from '../../../../core/store/selectors/core.selector';
import {
  selectTrainingSetExportedBlob,
  selectTrainingSetExporters,
  selectTrainingSetExportersServerError
} from '../../store/selectors/export.selector';
import {ShowErrorService} from '../../../../core/services/show-error.service';
import {TreeviewConfig, TreeviewItem} from 'ngx-treeview';
import {Collection} from '../../../../core/model/entities/collection';


@Component({
  selector: 'app-training-sets',
  templateUrl: './training-sets.component.html',
  styleUrls: ['./training-sets.component.css']
})
export class TrainingSetsComponent implements OnInit, OnDestroy {
  private authSubscription: Subscription;

  selectedExporterId: number;
  currentCursor = 'default';
  // private exportersSubscription: Subscription;
  trainingSetExporters$: Observable<TrainingSetExporter[]>;
  exportedTrainingSetBlobSubscription$: Subscription;
  userSubscription: Subscription;

  documents: Document[];
  exporting: boolean;
  private serverErrorSubscription: Subscription;


  treeviewItems: TreeviewItem[];
  treeViewValues: number[];
  treeViewConfig = TreeviewConfig.create({
    hasAllCheckBox: true,
    hasFilter: true,
    hasCollapseExpand: true,
    decoupleChildFromParent: false,
    maxHeight: 400
  });

  constructor(private store: Store<any>,
              private exporterService: ExporterService, private showErrorService: ShowErrorService
              ) {
  }

  ngOnInit() {
    this.authSubscription = this.store.select(selectAuthState).subscribe(next => {
      this.store.dispatch(new GetUser(next.userID));
    });

    this.trainingSetExporters$ = this.store.select(selectTrainingSetExporters);
    this.store.dispatch(new GetTrainingSetExporters());


    /*this.exportersSubscription = this.store.select(selectTrainingSetExporters).subscribe(next => {
        const exportersFormArray = (this.form.get('exportersFormArray') as FormArray);
        if (next && exportersFormArray.length === 0) {
          this.exporters = next;
          const controls = this.exporters.map(c => new FormControl(false));
          controls.forEach(c => {
            exportersFormArray.push(c);
          });
          this.onExporterSelected(controls.length - 1);
        }
      }
    );*/

    this.userSubscription = this.store.select(selectLoggedInUser).subscribe(next => {
      /*const documentsFormArray = (this.form.get('documentsFormArray') as FormArray);
      if (next && documentsFormArray.controls.length === 0) {
        if (next && next.permissions) {
          this.documents = flatten([...next.permissions.map((permission) => permission.collection.documents)]);
          const controls = this.documents.map(c => new FormControl(false));
          controls.forEach(c => {
            documentsFormArray.push(c);
          });
        }
      }*/
      if (next) {
        if (next && next.permissions) {
          this.treeviewItems = this.buildTreeItems(next.permissions);
        }
      }
    });

    this.exportedTrainingSetBlobSubscription$ = this.store.select(selectTrainingSetExportedBlob).subscribe(next => {
      if (next) {
        this.saveBlobAsFile(next);
      }
    });

    this.serverErrorSubscription = this.store.select(selectTrainingSetExportersServerError).subscribe(next => {
      this.exporting = false;
      if (next) {
        this.showErrorService.warning(next);
        this.store.dispatch(new ResetExportServerError());
      }
    });
  }


  onExporterSelected(id: number) {
    this.selectedExporterId = id;
  }

  /*submit() {
    const selectedDocumentIDS = Array<number>();
    let index = 0;
    (this.form.get('documentsFormArray') as FormArray).controls.forEach(cb => {
      if (cb.value) {
        selectedDocumentIDS.push(this.documents[index].id);
      }
      index++;
    });

    // we better perform it using directly the service rather than using redux because we don't want to save the blob state
    this.currentCursor = 'wait';
    this.exporting = true;
    this.exporterService.downloadTrainingSet$(this.selectedExporterId, selectedDocumentIDS).subscribe(data => {
      const blob1 = new Blob([data], { type: 'application/x-gzip' });
      this.exporting = false;
      saveAs.saveAs(blob1, 'training_set.tgz'); // TODO file name
      this.currentCursor = 'default';
    });
  }*/


  ngOnDestroy(): void {
    this.authSubscription.unsubscribe();
    this.userSubscription.unsubscribe();
    // this.exportersSubscription.unsubscribe();
    this.serverErrorSubscription.unsubscribe();
    this.exportedTrainingSetBlobSubscription$.unsubscribe();
  }

  getButtonLabel() {
    if (this.exporting) {
      return 'Exporting... (it can take several minutes)';
    } else {
      return 'Export training set';
    }
  }

  doesNotHavePermission(trainingSetExporter: TrainingSetExporter) {
    if (trainingSetExporter.adminPermissionRequired) {
      return false; // true; // TODO - depende de usuario
    }
    return false;
  }

  onTreeVoewSelectedChange($event: any[]) {

  }

  onTreeViewFilterChange($event: string) {
  }

  private buildTreeItems(permissions: Permissions[]): TreeviewItem[] {
    const result: TreeviewItem[] = [];
    permissions.forEach(permission => {
      // TODO now we don't check any permission, only if the user has access to it
      const rootCollection = this.fillCollectionTreeItem(permission.collection, true);
      result.push(rootCollection);
    });
    return result;
  }

  private fillCollectionTreeItem(collection: Collection, collapsed: boolean): TreeviewItem {
    const children: TreeviewItem[] = [];
    if (collection.subcollections) {
      collection.subcollections.forEach(subcollection => {
        const childTreeItem = this.fillCollectionTreeItem(subcollection, false);
        children.push(childTreeItem);
      });
    }

    if (collection.documents) {
      collection.documents.forEach(document => {
        const treeItemDocument = new TreeviewItem({
          value: document.id, // we need document IDs
          text: document.name,
          collapsed: false,
          checked: false
        });
        children.push(treeItemDocument);
      });
    }

    const treeItem = new TreeviewItem({
      value: null, // we don't need collection IDS
      text: collection.name,
      collapsed,
      children
    });

    return treeItem;
  }


  onFilterChange($event: string) {

  }

  getTreeViewIcon(item: TreeviewItem) {
    if (item.collapsed) {
      return 'caret-right';
    } else {
      return 'caret-down';
    }
  }

  isFormValid() {
    return (this.selectedExporterId || this.selectedExporterId === 0) && this.treeViewValues && this.treeViewValues.length > 0;
  }

  submit() {
    // we better perform it using directly the service rather than using redux because we don't want to save the blob state
    this.exporting = true;
    this.store.dispatch(new DownloadTrainingSet(this.selectedExporterId, this.treeViewValues));
  }

  private saveBlobAsFile(blob: Blob) {
    if (this.exporting) {
      this.exporting = false;
      const blob1 = new Blob([blob], {type: 'application/x-gzip'});
      saveAs.saveAs(blob1, 'training_set.tgz'); // TODO file name
    }

  }
}
