import { Component, OnInit } from '@angular/core';
import { FileUploader } from 'ng2-file-upload';
import { ApiRestClientService } from 'src/app/core/services/api-rest-client.service';
import { NewClassifierModel } from '../../models/newclassifiermodel'
import { Observable, Subscription } from 'rxjs';
import { Collection } from 'src/app/core/model/entities/collection';
import { Store } from '@ngrx/store';
import { NewProjectState } from 'src/app/features/new-project/store/state/new-project.state';
import { selectCollections } from 'src/app/features/new-project/store/selectors/new-project.selector';
import { GetCollections } from 'src/app/features/new-project/store/actions/new-project.actions';
import { Project } from 'src/app/core/model/entities/project';
import { DialogsService } from 'src/app/shared/services/dialogs.service';

@Component({
  selector: 'app-registermodel',
  templateUrl: './registermodel.component.html',
  styleUrls: ['./registermodel.component.css']
})
export class RegistermodelComponent implements OnInit {

  public uploader : FileUploader
  private url: string
  private registerModel : NewClassifierModel = {}
  private collections$ : Observable<Collection[]>
  private collections : Collection[]
  private collectionSubs : Subscription
  private projects : Project[]
  private collectionSelected : boolean

  constructor(private apiRestService : ApiRestClientService, private store: Store<NewProjectState>, private dservice : DialogsService) 
  {
    this.collections$ = store.select(selectCollections);
  }

  ngOnInit() 
  {
    this.store.dispatch(new GetCollections());

    this.url = this.apiRestService.url + "/classifierModels/uploadmodel"
    this.uploader = new FileUploader({url: this.url})

    this.collectionSubs = this.collections$.subscribe((collections : Collection[]) => {
      this.collections = collections
    })

    this.uploader.onBuildItemForm = (item,form)=>{
      form.append('eName', this.registerModel.eName)
      form.append('eClassifierType', this.registerModel.eClassifierType)
      form.append('eNotationType', this.registerModel.eNotationType)
      form.append('eCollection', this.registerModel.eCollection)
      form.append('eProject', this.registerModel.eProject)
      form.append('eManuscriptType', this.registerModel.eManuscriptType)
      item.alias = 'eModelFile'
    }

    this.uploader.onSuccessItem = (item) =>
    {
      this.dservice.showConfirmarion("Success", "Your model was successfully uploaded to the server")
    }

    this.uploader.onErrorItem = (item) =>{
      console.log("Error")
    }

    this.uploader.onBeforeUploadItem = (item) => {
      item.withCredentials = false;
    };
    this.uploader.onAfterAddingFile = (file) => {
      file.withCredentials = false;
    };
  }

  getModelProjects()
  {
    console.log(this.registerModel.eCollection)
    let collectionID = this.registerModel.eCollection

    if(collectionID != -1)
    {
      let selCollection : Collection
      this.collections.forEach((collection : Collection) => {
        if(collection.id == collectionID)
        {
          this.projects = collection.projects;
          this.collectionSelected = true
          console.log(this.projects)
        }
      })
    }
    else
    {
      this.registerModel.eProject = "-1"
      this.projects = []
      this.collectionSelected = false
    }
  }

  onSubmit()
  {
    console.log(this.registerModel)
    console.log(this.uploader.queue)
    this.uploader.uploadAll()
  }

}
