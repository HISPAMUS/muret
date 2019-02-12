import { Injectable } from '@angular/core';
import {NGXLogger} from 'ngx-logger';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {RegionType} from '../model/region-type';
import {Image} from '../model/image';
import {share} from 'rxjs/operators';
import {Page} from '../model/page';
import {Region} from '../model/region';
import {Symbol} from '../model/symbol';
import {Strokes} from '../model/strokes';
import {Point} from '../model/point';
import {PostStrokes} from '../payloads/post-strokes';
import {RestClientService} from "./rest-client.service";

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private urlImage: string;

  constructor(private logger: NGXLogger,
    private restClientService: RestClientService) {
    this.urlImage = environment.apiEndpoint + '/image';
  }

  public getImage$(id: number): Observable<Image> {
    return this.restClientService.httpGet$(this.urlImage + '/get/' + id, 'Fetching image with id ' + id);
  }

  getMasterImage$(imageID: number): Observable<Blob> {
    return this.restClientService.httpGetBlob(this.urlImage + '/master/' + imageID, 'Fetching master image ' + imageID);
  }

  getThumbnailImage$(imageID: number): Observable<Blob> {
    return this.restClientService.httpGetBlob(this.urlImage + '/thumbnail/' + imageID, 'Fetching thumbnail image ' + imageID);
  }

  getPreviewImage$(imageID: number): Observable<Blob> {
    return this.restClientService.httpGetBlob(this.urlImage + '/preview/' + imageID, 'Fetching preview image ' + imageID);
  }

  updateRegionBoundingBox$(id: number, fromX: number, fromY: number, toX: number, toY: number): Observable<any> {
    //TODO Cambiar por PUT
    return this.restClientService.httpGet$(this.urlImage + '/regionUpdate/' + id + '/'
      + fromX + '/' + fromY + '/'
      + toX  + '/' + toY, 'Updating region bounding box of id: ' + id);
  }

  updateRegionType$(id: number, regionType: RegionType): Observable<any> {
    //TODO Cambiar por PUT
    return this.restClientService.httpGet$(this.urlImage + '/regionUpdateType/' + id + '/' + regionType.id
      , 'Updating region type of id' + id + ' to ' + regionType.name);
  }

  updatePageBoundingBox$(id: number, fromX: number, fromY: number, toX: number, toY: number): Observable<any> {
    this.logger.debug('IM3WSService: updating page bounding box of id: ' + id);

    //TODO Cambiar por PUT
    return this.restClientService.httpGet$(this.urlImage + '/pageUpdate/' + id + '/'
      + fromX + '/' + fromY + '/'
      + toX  + '/' + toY,
      'Updating page bounding box of id ' + id);
  }

  splitPage$(imageId: number, imageX: number): Observable<Array<Page>> {
    //TODO Cambiar por PUT
    return this.restClientService.httpGet$<Array<Page>>(this.urlImage + '/pageSplit/' + imageId + '/' + imageX,
      'Splitting page image with id ' + imageId);
  }

  splitRegion$(imageId: number, imageX: number, imageY: number): Observable<Array<Page>> {
    //TODO Cambiar por PUT
    return this.restClientService.httpGet$<Array<Page>>(this.urlImage + '/regionSplit/' + imageId + '/' + imageX + '/' + imageY,
      'IM3WSService: splitting region image with id ' + imageId);
  }

  clearDocumentAnalysis$(imageId: number): Observable<any> {
    //TODO Cambiar por PUT

    return this.restClientService.httpGet$<void>(this.urlImage + '/documentAnalysisClear/' + imageId,
      'Clearing document analysis of image with id ' + imageId);
  }


  createSymbolFromBoundingBox$(region: Region, fromX: number, fromY: number, toX: number, toY: number): Observable<Symbol> {
    //TODO Cambiar por PUT
    return this.restClientService.httpGet$<Symbol>(this.urlImage + '/createSymbolFromBoundingBox/' + region.id + '/'
      + fromX + '/' + fromY + '/'
      + toX  + '/' + toY,
      'Create symbol from bounding box in region ' + region.id)
      .pipe(share()); // if not, two calls are made for the same request due to CORS checking
    //TODO Comprobar esto del share
  }

  createSymbolFromStrokes$(region: Region, currentStrokes: Strokes): Observable<Symbol> {
    const points: Point[][] = [[]];
    currentStrokes.strokeList.forEach(stroke => {
      points.push(stroke.points);
    });

    const postStrokes = new PostStrokes(region.id, points);

    return this.restClientService.httpPost<Symbol>(this.urlImage + '/createSymbolFromStrokes', postStrokes,
      'Create symbol from strokes in region ' + region.id)
      .pipe(share()); // if not, two calls are made for the same request due to CORS checking
      //TODO Comprobar esto del share
  }


  deleteSymbol$(regionID: number, symbolID: number): Observable<any> {
    //TODO Cambiar por DELETE
    return this.restClientService.httpGet$<boolean>(this.urlImage + '/removeSymbol/' + regionID + '/' + symbolID,
      'Deleting symbol from region with id ' + regionID + ' with symbol id: ' + symbolID);
  }
}
