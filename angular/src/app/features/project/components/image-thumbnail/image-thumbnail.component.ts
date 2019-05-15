import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
// import {Lightbox, LightboxConfig} from 'ngx-lightbox';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';
import {Image} from '../../../../core/model/entities/image';
import {ImageFilesService} from '../../../../core/services/image-files.service';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Project} from '../../../../core/model/entities/project';
import {Lightbox, LightboxConfig} from 'ngx-lightbox';

@Component({
  selector: 'app-image-thumbnail',
  templateUrl: './image-thumbnail.component.html',
  styleUrls: ['./image-thumbnail.component.css']
})
// see https://stackoverflow.com/questions/49411283/angular-5-http-get-images-from-back-end
export class ImageThumbnailComponent implements OnInit {
  @Input() project: Project;
  @Input() image: Image;
  @Input() projectPath: string;
  loadingImage = 'assets/loading.svg';
  loadedImage$: Observable<SafeResourceUrl>;


  constructor(private router: Router,
              private imageFilesService: ImageFilesService,
              private lightbox: Lightbox,
              private lighboxConfig: LightboxConfig,
              private sanitizer: DomSanitizer) {
    lighboxConfig.fitImageInViewPort = true;
  }

  ngOnInit() {
    this.loadedImage$ = this.imageFilesService.getThumbnailImageBlob$(this.projectPath, this.image.id).pipe(
      map(imageBlob => this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)))
      );

    /*this.imageFilesService.getThumbnailImage$(this.projectPath, this.image.id).subscribe(
      imageBlob => this.imageThumbnail.nativeElement.src = window.URL.createObjectURL(imageBlob));*/
  }

  previewImage() {
    this.imageFilesService.getPreviewImageBlob$(this.projectPath, this.image.id).subscribe(imageBlob => {
      const albums = []; // used by Lightbox

      const album = {
        src: this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)),
        caption: this.image.filename,
      };

      albums.push(album);
      this.lightbox.open(albums);
      // window.open(window.URL.createObjectURL(imageBlob), 'Preview ' + this.image.filename, 'widthPercentage=1280,heightPercentage=720');
    });
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.image.id]);
  }

  openAgnostic() {
    this.router.navigate(['agnosticrepresentation', this.image.id]);
  }

  openSemantic() {
    this.router.navigate(['semanticrepresentation', this.image.id]);
  }
}
