import { Component, OnInit } from '@angular/core';
import { FileUploader } from 'ng2-file-upload';
import { ApiRestClientService } from 'src/app/core/services/api-rest-client.service';
import { NewClassifier } from '../../model/new-classifier';
import { Observable, Subscription } from 'rxjs';
import { Collection } from 'src/app/core/model/entities/collection';
import { Store } from '@ngrx/store';
import { Document } from 'src/app/core/model/entities/document';
import { DialogsService } from 'src/app/shared/services/dialogs.service';
import {NewDocumentState} from "../../../new-document-old/store/state/new-document.state";
import {selectNewDocumentCollections} from "../../../new-document-old/store/selectors/new-document.selector";
import {GetCollections} from "../../../new-document-old/store/actions/new-document.actions";

@Component({
  selector: 'app-register-model',
  templateUrl: './register-model.component.html',
  styleUrls: ['./register-model.component.css']
})
export class RegisterModelComponent implements OnInit {

  public uploader: FileUploader;
  private url: string;
  registerModel: NewClassifier = {};
  collections$: Observable<Collection[]>;
  private collections: Collection[];
  private collectionSubs: Subscription;
  documents: Document[];
  collectionSelected: boolean;

  constructor(private apiRestService: ApiRestClientService, private store: Store<NewDocumentState>, private dservice: DialogsService) {
    this.collections$ = store.select(selectNewDocumentCollections);
  }

  ngOnInit() {
    this.store.dispatch(new GetCollections());

    this.url = this.apiRestService.url + '/classifierModels/uploadmodel';
    this.uploader = new FileUploader({url: this.url});

    this.collectionSubs = this.collections$.subscribe((collections: Collection[]) => {
      this.collections = collections;
    });

    this.uploader.onBuildItemForm = (item, form) => {
      form.append('eName', this.registerModel.eName);
      form.append('eClassifierType', this.registerModel.eClassifierType);
      form.append('eNotationType', this.registerModel.eNotationType);
      form.append('eCollection', this.registerModel.eCollection);
      form.append('eDocument', this.registerModel.eDocument);
      form.append('eManuscriptType', this.registerModel.eManuscriptType);
      item.alias = 'eModelFile';
    };

    this.uploader.onSuccessItem = (item) => {
      this.dservice.showConfirmation('Success', 'Your model was successfully uploaded to the server');
    };

    this.uploader.onErrorItem = (item) => {
      console.log('Error');
    };

    this.uploader.onBeforeUploadItem = (item) => {
      item.withCredentials = false;
    };
    this.uploader.onAfterAddingFile = (file) => {
      file.withCredentials = false;
    };
  }

  getModelDocuments() {
    console.log(this.registerModel.eCollection);
    const collectionID = this.registerModel.eCollection;

    if (collectionID !== -1) {
      // let selCollection: Collection;
      this.collections.forEach((collection: Collection) => {
        if (collection.id === collectionID) {
          this.documents = collection.documents;
          this.collectionSelected = true;
          /// console.log(this.documents);
        }
      });
    } else {
      this.registerModel.eDocument = '-1';
      this.documents = [];
      this.collectionSelected = false;
    }
  }

  onSubmit() {
    // console.log(this.registerModel);
    // console.log(this.uploader.queue);
    this.uploader.uploadAll();
  }

}
