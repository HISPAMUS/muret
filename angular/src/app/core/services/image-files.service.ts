import { Injectable } from '@angular/core';
import {NGXLogger} from 'ngx-logger';
import {Observable} from 'rxjs';
import {ApiRestClientService} from './api-rest-client.service';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';
import {BoundingBox} from '../model/entities/bounding-box';

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

  private getImageBlob$(documentPath: string, imageType: ImageType, imageID: number): Observable<Blob> {
    let blob = this.imagesCache.get(imageType).get(imageID);
    if (blob) {
      return blob;
    } else {
      let url: string;
      if (documentPath == null) {
        url = `${endpoint}/${imageType}/${imageID}`;
      } else {
        url = `${endpoint}/${documentPath}/${imageType}/${imageID}`;
      }

      blob = this.apiRestClientService.getBlob$(url);
      this.imagesCache.get(imageType).set(imageID, blob);
      return blob;
    }
  }

  /**
   * @param documentPath May be null
   */
  public getMasterImageBlob$(documentPath: string, imageID: number): Observable<Blob> {
    return this.getImageBlob$(documentPath, ImageType.master, imageID);
  }

  public getThumbnailImageBlob$(documentPath: string, imageID: number): Observable<Blob> {
    return this.getImageBlob$(documentPath, ImageType.thumbnail, imageID);
  }

  public getPreviewImageBlob$(documentPath: string, imageID: number): Observable<Blob> {
    return this.getImageBlob$(documentPath, ImageType.preview, imageID);
  }

  /**
   * @param documentPath May be null
   */
  public getCroppedMasterImageBlob$(imageID: number, boundingBox: BoundingBox): Observable<Blob> {
    const data = {
      imageID,
      boundingBox
    };

    const url = `${endpoint}/croppedImage/${imageID}/${boundingBox.fromX}/${boundingBox.fromY}/${boundingBox.toX}/${boundingBox.toY}`;
    return this.apiRestClientService.getBlob$(url);
  }

}

