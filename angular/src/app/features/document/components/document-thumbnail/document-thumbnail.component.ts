import {Component, Input, OnInit} from '@angular/core';
import {Part} from "../../../../core/model/entities/part";
import {ImageFilesService} from "../../../../core/services/image-files.service";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-document-thumbnail',
  templateUrl: './document-thumbnail.component.html',
  styleUrls: ['./document-thumbnail.component.css']
})
export class DocumentThumbnailComponent implements OnInit {
  @Input() documentPath: string;
  @Input() imageID: number;
  @Input() filename: string;
  @Input() documentParts: Part[];
  imagePartIds: number[]; // set of part ids
  loadedImage$: Observable<SafeResourceUrl>;
  loadingImage = "assets/images/loading.svg";

  constructor(private imageFilesService: ImageFilesService) { // }, private sanitizer: DomSanitizer) {
    //TODO Quitar
    this.imagePartIds = [13];
  }

  ngOnInit(): void {
    this.loadedImage$ = this.imageFilesService.getThumbnailImageBlob$(this.documentPath, this.imageID).pipe(
      //map(imageBlob => this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)))
      map(imageBlob => window.URL.createObjectURL(imageBlob))
    );
  }

}
