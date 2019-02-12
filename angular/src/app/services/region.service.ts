import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {NGXLogger} from 'ngx-logger';
import {Observable} from 'rxjs';
import {RegionType} from '../model/region-type';
import {catchError} from 'rxjs/operators';
import {RestClientService} from "./rest-client.service";

@Injectable({
  providedIn: 'root'
})
export class RegionService {
  private urlRegionTypes: string;

  constructor(private restClientService: RestClientService,
              private logger: NGXLogger) {
    this.urlRegionTypes = environment.apiEndpoint + '/regiontypes';
  }

  getRegionTypes(): Observable<RegionType[]> {
    return this.restClientService.httpGet$<RegionType[]>(this.urlRegionTypes,
      'Fetching region types');
  }

}
