import { Injectable } from '@angular/core';
import {NGXLogger} from 'ngx-logger';
import {Observable} from 'rxjs';
import { of } from 'rxjs';
import {map, share, tap} from 'rxjs/operators';
import {ApiRestClientService} from './api-rest-client.service';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';
import {ActivatedRoute} from '@angular/router';

enum ImageType {
  master = 'master',
  preview = 'preview',
  thumbnail = 'thumbnail'
}
const endpoint = 'imagefiles';
@Injectable({
  providedIn: 'root'
})
export class ImageFilesService {
  private imagesCache: Map<string, Map<number, Observable<Blob>>>; // first key = image type, key = image primary key
  constructor(private logger: NGXLogger, private apiRestClientService: ApiRestClientService,
              private sanitizer: DomSanitizer) {
    this.imagesCache = new Map();

    const keys = Object.keys(ImageType).map((imageTypeKey) => this.imagesCache.set(imageTypeKey, new Map()));
  }

  private getImageBlob$(projectPath: string, imageType: ImageType, imageID: number): Observable<Blob> {
    let blob = this.imagesCache.get(imageType).get(imageID);
    if (blob) {
      return blob;
    } else {
      let url: string;
      if (projectPath == null) {
        url = `${endpoint}/${imageType}/${imageID}`;
      } else {
        url = `${endpoint}/${projectPath}/${imageType}/${imageID}`;
      }

      blob = this.apiRestClientService.getBlob$(url);
      this.imagesCache.get(imageType).set(imageID, blob);
      return blob;
    }
  }

  /**
   * @param projectPath May be null
   */
  public getMasterImageBlob$(projectPath: string, imageID: number): Observable<Blob> {
    return this.getImageBlob$(projectPath, ImageType.master, imageID);
  }

  public getThumbnailImageBlob$(projectPath: string, imageID: number): Observable<Blob> {
    return this.getImageBlob$(projectPath, ImageType.thumbnail, imageID);
  }

  public getPreviewImageBlob$(projectPath: string, imageID: number): Observable<Blob> {
    return this.getImageBlob$(projectPath, ImageType.preview, imageID);
  }
}

