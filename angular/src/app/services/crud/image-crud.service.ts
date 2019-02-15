import { Injectable } from '@angular/core';
import {NGXLogger} from 'ngx-logger';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import { of } from 'rxjs';
import {Image} from '../../model/image';
import {map, share, tap} from 'rxjs/operators';
import {RestClientService} from "../rest-client.service";
import {ImageBlobs} from "../../model/image-blobs";

@Injectable({
  providedIn: 'root'
})
export class ImageCrudService {
  private urlImage: string;

  private imageBlobsMap: Map<number, ImageBlobs>;

  constructor(private logger: NGXLogger,
    private restClientService: RestClientService) {
    this.urlImage = environment.apiEndpoint + '/imagecrud';
    this.imageBlobsMap = new Map<number, ImageBlobs>();
  }

  public getImage$(id: number): Observable<Image> {
    return this.restClientService.httpGet$(this.urlImage + '/get/' + id, 'Fetching image with id ' + id);
  }

  private getImageBlobs(image_id: number): ImageBlobs {
    if (this.imageBlobsMap.has(image_id)) {
      return this.imageBlobsMap.get(image_id);
    } else {
      //const imageBlobs: ImageBlobs = {};TODO
      this.imageBlobsMap.set(image_id, null);
      //TODO return imageBlobs;
      return null;
    }
  }

  getMasterImage$(imageID: number): Observable<Blob> {
    let blob = this.getImageBlobs(imageID).master;
    if (blob) {
      return of(blob);
    } else {
      return this.restClientService.httpGetBlob(this.urlImage + '/master/' + imageID, 'Fetching master image ' + imageID).pipe(
        tap((next: Blob) => { this.getImageBlobs(imageID).master = next})
      );
    }
  }

  getThumbnailImage$(imageID: number): Observable<Blob> {
    let blob = this.getImageBlobs(imageID).thumbnail;
    if (blob) {
      return of(blob);
    } else {
      return this.restClientService.httpGetBlob(this.urlImage + '/thumbnail/' + imageID, 'Fetching thumbnail image ' + imageID).pipe(
        tap((next: Blob) => { this.getImageBlobs(imageID).thumbnail = next})
      );
    }
  }

  getPreviewImage$(imageID: number): Observable<Blob> {
    let blob = this.getImageBlobs(imageID).thumbnail;
    if (blob) {
      return of(blob);
    } else {
      return this.restClientService.httpGetBlob(this.urlImage + '/preview/' + imageID, 'Fetching preview image ' + imageID).pipe(
        tap((next: Blob) => { this.getImageBlobs(imageID).thumbnail = next})
      );
    }
  }



}
