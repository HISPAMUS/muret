import { Component, OnInit } from '@angular/core';
import {FileUploader} from 'ng2-file-upload';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ProjectService} from '../../services/project.service';

@Component({
  selector: 'app-upload-images',
  templateUrl: './upload-images.component.html',
  styleUrls: ['./upload-images.component.css']
})
export class UploadImagesComponent implements OnInit {
  public uploader: FileUploader;
  public hasBaseDropZoneOver = true;
  public hasAnotherDropZoneOver = false;
  private projectID: number;

  // don't use here REDUX for the FileUploader
  constructor(private route: ActivatedRoute, private router: Router, private projectService: ProjectService) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.uploader = new FileUploader({url: this.projectService.getProjectUploadURL()});
      this.projectID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      // Add in the other upload form parameters.
      this.uploader.onBuildItemForm = (item, form) => {
        form.append('projectid', this.projectID);
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

  continueWithProject() {
    this.router.navigate(['project', this.projectID]);
  }
}
