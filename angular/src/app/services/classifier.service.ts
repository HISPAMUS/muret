import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {NGXLogger} from 'ngx-logger';
import {Observable} from 'rxjs';
import {ClassifierType} from '../model/classifier-type';
import {RestClientService} from "./rest-client.service";

@Injectable({
  providedIn: 'root'
})
export class ClassifierService {
  private urlClassifierTypes: string;

  constructor(private restClientService: RestClientService,
              private logger: NGXLogger) {
    this.urlClassifierTypes = environment.apiEndpoint + '/classifiers';
  }

  getClassifierTypes$(): Observable<ClassifierType[]> {
    // TODO Pasarle usuario actual
    return this.restClientService.httpGet$<ClassifierType[]>(this.urlClassifierTypes,
      'Fetching classifier types');
  }

}
