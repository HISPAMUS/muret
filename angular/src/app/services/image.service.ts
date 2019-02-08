import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NGXLogger} from 'ngx-logger';
import {environment} from '../../environments/environment';
import {AuthService} from './auth.service';
import {DialogsService} from './dialogs.service';
import {Observable} from 'rxjs';
import {RegionType} from '../model/region-type';
import {Image} from '../model/image';
import {catchError, share} from 'rxjs/operators';
import {Page} from '../model/page';
import {Region} from '../model/region';
import {Symbol} from '../model/symbol';
import {Strokes} from '../model/strokes';
import {Point} from '../model/point';
import {PostStrokes} from '../payloads/post-strokes';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private urlImage: string;

  constructor(private http: HttpClient,
              private logger: NGXLogger,
              private authService: AuthService,
              private dialogService: DialogsService) {
    this.urlImage = environment.apiEndpoint + '/image';
  }

  updateRegionBoundingBox(id: number, fromX: number, fromY: number, toX: number, toY: number): Observable<any> {
    this.logger.debug('IM3WSService: updating region bounding box of id: ' + id);

    const result = this.http.get(this.urlImage + '/regionUpdate/' + id + '/'
      + fromX + '/' + fromY + '/'
      + toX  + '/' + toY
      , this.authService.getHttpAuthOptions());
    result.subscribe(res => {
      this.logger.debug('Update region bounding box result: ' + res);
    });
    return result;

  }

  updateRegionType(id: number, regionType: RegionType): Observable<any> {
    this.logger.debug('IM3WSService: updating region type of id: ' + id + ' to ' + regionType.name);

    const result = this.http.get(this.urlImage + '/regionUpdateType/' + id + '/' + regionType.id
      , this.authService.getHttpAuthOptions());
    result.subscribe(res => {
      this.logger.debug('Update region type update result: ' + res);
    });
    return result;

  }



  updatePageBoundingBox(id: number, fromX: number, fromY: number, toX: number, toY: number): Observable<any> {
    this.logger.debug('IM3WSService: updating page bounding box of id: ' + id);

    const result = this.http.get(this.urlImage + '/pageUpdate/' + id + '/'
      + fromX + '/' + fromY + '/'
      + toX  + '/' + toY
      , this.authService.getHttpAuthOptions());
    result.subscribe(res => {
      this.logger.debug('Update page bounding box result: ' + res);
    });
    return result;
  }


  // ############### IMAGES ###############
  public getImage$(id: number): Observable<Image> {
    this.logger.debug('IM3WSService: fetching image with id ' + id);
    return this.http.get<Image>(this.urlImage + '/get/' + id, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('getImage$ with id=' + id, null))
      );
  }


  splitPage(imageId: number, imageX: number): Observable<Array<Page>> {
    this.logger.debug('IM3WSService: splitting page image with id ' + imageId);
    return this.http.get<Array<Page>>(this.urlImage + '/pageSplit/' + imageId + '/' + imageX, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('splitPage with id=' + imageId, null))
      );
  }

  splitRegion(imageId: number, imageX: number, imageY: number): Observable<Array<Page>> {
    this.logger.debug('IM3WSService: splitting region image with id ' + imageId);
    return this.http.get<Array<Page>>(this.urlImage + '/regionSplit/' + imageId + '/' + imageX + '/' + imageY,
      this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('splitRegion with id=' + imageId, null))
      );
  }

  clearDocumentAnalysis(imageId: number) {
    this.logger.debug('IM3WSService: clearing document analysis of image with id ' + imageId);
    return this.http.get<void>(this.urlImage + '/documentAnalysisClear/' + imageId, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('clearDocumentAnalysis with id=' + imageId, null))
      );
  }



  createSymbolFromBoundingBox(region: Region, fromX: number, fromY: number, toX: number, toY: number): Observable<Symbol> {
    this.logger.debug('IM3WSService: create symbol from bounding box in region ' + region.id);

    const result = this.http.get<Symbol>(this.urlImage + '/createSymbolFromBoundingBox/' + region.id + '/'
      + fromX + '/' + fromY + '/'
      + toX  + '/' + toY
      , this.authService.getHttpAuthOptions())
      .pipe(share()); // if not, two calls are made for the same request due to CORS checking

    result.subscribe(res => {
      region.symbols.push(res); // the im3ws spring service just returns the new symbol, not the complete region on each symbol insert
      this.logger.debug('Symbol from bounding box in region ' + region.id);

    });
    return result;
  }

  createSymbolFromStrokes(region: Region, currentStrokes: Strokes): Observable<Symbol> {
    this.logger.debug('IM3WSService: create symbol from strokes in region ' + region.id);

    const points: Point[][] = [[]];
    currentStrokes.strokeList.forEach(stroke => {
      points.push(stroke.points);
    });

    const postStrokes = new PostStrokes(region.id, points);

    const result = this.http.post<Symbol>(this.urlImage + '/createSymbolFromStrokes', postStrokes
      , this.authService.getHttpAuthOptions())
      .pipe(share()); // if not, two calls are made for the same request due to CORS checking

    result.subscribe(res => {
      region.symbols.push(res); // the im3ws spring service just returns the new symbol, not the complete region on each symbol insert
      this.logger.debug('Symbol from strokes in region ' + region.id);
    });
    return result;
  }


  deleteSymbol(regionID: number, symbolID: number): Observable<any> {
    this.logger.debug('IM3WSService: deleting symbol from region with id ' + regionID + ' with symbol id: ' + symbolID);

    return this.http.get<boolean>(this.urlImage + '/removeSymbol/' + regionID + '/' + symbolID
      , this.authService.getHttpAuthOptions());
  }
}
