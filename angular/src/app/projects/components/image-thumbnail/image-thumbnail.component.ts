import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {Image} from '../../../model/image';
import {ProjectURLS} from '../../../model/project-urls';
import {NGXLogger} from 'ngx-logger';
import {Router} from '@angular/router';
import {SessionDataService} from '../../../services/session-data.service';
import {RestClientService} from '../../../services/rest-client.service';
import {ImageCrudService} from "../../../services/crud/image-crud.service";
import {Lightbox, LightboxConfig} from "ngx-lightbox";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-image-thumbnail',
  templateUrl: './image-thumbnail.component.html',
  styleUrls: ['./image-thumbnail.component.css']
})
// see https://stackoverflow.com/questions/49411283/angular-5-http-get-images-from-back-end
export class ImageThumbnailComponent implements OnInit {
  @Input() image: Image;
  @ViewChild('imageThumbnail') imageThumbnail: ElementRef;

  constructor(private logger: NGXLogger, private router: Router, private sessionDataService: SessionDataService,
              private imageService: ImageCrudService, private _lightbox: Lightbox, private _lighboxConfig: LightboxConfig,
              private sanitizer: DomSanitizer) {
    _lighboxConfig.fitImageInViewPort = true;
    _lighboxConfig.showImageNumberLabel = false;
  }

  ngOnInit() {
    this.imageService.getThumbnailImage$(this.image.id).subscribe(imageBlob => {
      this.imageThumbnail.nativeElement.src = window.URL.createObjectURL(imageBlob)
    });
  }

  openImage() {
    this.logger.debug('Opening image ' + this.image.id);

    // this call retrieves the whole image data (the current image does not contain all lazy relations)
    this.imageService.getImage$(this.image.id).subscribe(next => {
      this.sessionDataService.currentImage = next;
      this.router.navigate(['/image']);
    });
 }

  previewImage() {
    this.imageService.getPreviewImage$(this.image.id).subscribe(imageBlob => {
      const albums = []; // used by Lightbox

      const album = {
        src: this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)),
        caption: this.image.filename,
      };

      albums.push(album);
      this._lightbox.open(albums, );
    });

  }
}
