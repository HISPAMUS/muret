import {Component, Input, OnInit} from '@angular/core';
import {Image} from '../model/image';
import {ProjectURLS} from '../model/project-urls';
import {NGXLogger} from 'ngx-logger';
import {Router} from '@angular/router';
import {SessionDataService} from '../session-data.service';
import {Im3wsService} from '../services/im3ws.service';

@Component({
  selector: 'app-image-thumbnail',
  templateUrl: './image-thumbnail.component.html',
  styleUrls: ['./image-thumbnail.component.css']
})
export class ImageThumbnailComponent implements OnInit {
  @Input() projectURLs: ProjectURLS;
  @Input() image: Image;
  constructor(private logger: NGXLogger, private router: Router, private sessionDataService: SessionDataService,
              private im3wsService: Im3wsService) {
  }

  ngOnInit() {
    // this.logger.debug('ImageThumbnails at: ' + this.projectURLs.thumbnails);
  }

  openImage(image: Image) {
    this.logger.debug('Opening image ' + image.id + ' in URL ' + this.projectURLs);

    // this call retrieves the whole image data (the current image does not contain all lazy relations)
    this.im3wsService.imageService.getImage$(image.id).
      subscribe(serviceImage => {
        this.sessionDataService.currentImageMastersURL = this.projectURLs.masters;
        this.sessionDataService.currentImage = serviceImage;
        this.router.navigate(['/image']);
      });
 }
}
