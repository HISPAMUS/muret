import { Injectable } from '@angular/core';
import {NGXLogger} from 'ngx-logger';
import {Observable} from 'rxjs';
import {ApiRestClientService} from './api-rest-client.service';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';
import {BoundingBox} from '../model/entities/bounding-box';
import {environment} from "../../../environments/environment";

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
  iiif = environment.iiifEndpoint;

  private imagesCache: Map<string, Map<number, Observable<Blob>>>; // first key = image type, key = image primary key
  constructor(private logger: NGXLogger, private apiRestClientService: ApiRestClientService,
              private sanitizer: DomSanitizer) {
    this.imagesCache = new Map();

    const keys = Object.keys(ImageType).map((imageTypeKey) => this.imagesCache.set(imageTypeKey, new Map()));
  }

  // @deprecated
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
   * @deprecated - Use getMasterImageURL
   * @param documentPath May be null
   */
  public getMasterImageBlob$(documentPath: string, imageID: number): Observable<Blob> {
    return this.getImageBlob$(documentPath, ImageType.master, imageID);
  }

  /**
   * @deprecated - Use getThumbnailImageURL
   * @param documentPath
   * @param imageID
   */
  public getThumbnailImageBlob$(documentPath: string, imageID: number): Observable<Blob> {
    return this.getImageBlob$(documentPath, ImageType.thumbnail, imageID);
  }

  /**
   * @deprecated - Use getPreviewImageURL
   * @param documentPath
   * @param imageID
   */
  public getPreviewImageBlob$(documentPath: string, imageID: number): Observable<Blob> {
    return this.getImageBlob$(documentPath, ImageType.preview, imageID);
  }

  /**
   * @deprecated - Use getCroppedImageURL
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

  getThumbnailImageURL(documentPath: string, filename: string) {
    const url = this.iiif + '/' + documentPath + ':masters:' + filename + '/full/!132,200/0/default.jpg';
    console.log(url);
    return url;
  }

  getPreviewImageURL(documentPath: string, filename: string) {
    return this.iiif + '/' + documentPath + ':masters:' + filename + '/full/!1280,720/0/default.jpg';
  }

  getMasterImageURL(documentPath: string, filename: string) {
    return this.iiif + '/' + documentPath + ':masters:' + filename + '/full/full/0/default.jpg';
  }

}

