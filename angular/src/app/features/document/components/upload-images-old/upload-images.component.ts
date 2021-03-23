import { Component, OnInit } from '@angular/core';
import {FileUploader} from 'ng2-file-upload';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {DocumentService} from '../../services/document.service';

@Component({
  selector: 'app-upload-images',
  templateUrl: './upload-images.component.html',
  styleUrls: ['./upload-images.component.css']
})
export class UploadImagesComponent implements OnInit {
  public uploader: FileUploader;
  public hasBaseDropZoneOver = true;
  public hasAnotherDropZoneOver = false;
  private documentID: number;

  // don't use here REDUX for the FileUploader
  constructor(private route: ActivatedRoute, private router: Router, private documentService: DocumentService) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.uploader = new FileUploader({url: this.documentService.getDocumentUploadURL()});
      this.documentID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      // Add in the other upload form parameters.
      this.uploader.onBuildItemForm = (item, form) => {
        form.append('documentid', this.documentID);
      };

      // it avoids CORS problems
      this.uploader.onBeforeUploadItem = (item) => {
        item.withCredentials = false;
      };
      this.uploader.onAfterAddingFile = (file) => {
        file.withCredentials = false;
      };
    });
  }

  public fileOverBase(e: any): void {
    this.hasBaseDropZoneOver = e;
  }

  public fileOverAnother(e: any): void {
    this.hasAnotherDropZoneOver = e;
  }

  continueWithDocument() {
    this.router.navigate(['document', this.documentID]);
  }
}
