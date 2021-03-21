import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Observable} from 'rxjs';
import {Region} from '../../../core/model/entities/region';
import {Notation} from '../../../shared/services/notation';

@Injectable()
export class SemanticRepresentationService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  /**
   * It returns the encoding
   */
  getNotation$(region: Region, mensustriche: boolean, renderer: 'verovio' | 'im3'): Observable<Notation> {
    const url = `semantic/notation/${region.id}/${mensustriche}/${renderer}`;
    return this.apiRestClientService.get$<Notation>(url);
  }

  agnostic2Semantic$(modelID: string, region: Region, mensustriche: boolean, renderer: 'verovio' | 'im3'): Observable<Notation> {
    const url = `semantic/agnostic2semantic/${modelID}/${region.id}/${mensustriche}/${renderer}`;
    return this.apiRestClientService.get$<Notation>(url);
  }

  /**
   * It returns the encoding
   */
  sendSemanticEncoding$(region: Region,
                        semanticEncoding: string, mensustriche: boolean, renderer: 'verovio' | 'im3'): Observable<Notation> {
    if (semanticEncoding && semanticEncoding.trim().length > 0) {
      const url = `semantic/semanticEncoding/${region.id}/${mensustriche}/${renderer}`;
      return this.apiRestClientService.put$(url, semanticEncoding);
    } else {
      const url = `semantic/clearSemanticEncoding`;
      return this.apiRestClientService.delete$(url, region.id);
    }
  }

  changeNotationType$(regionID: number, notationType: string): Observable<Region> {
    if (notationType) {
      const url = `semantic/changeNotationType/${regionID}/${notationType}`;
      return this.apiRestClientService.get$(url);
    } else {
      const url = `semantic/clearNotationType`;
      return this.apiRestClientService.delete$(url, regionID);
    }
  }

  // hasta aquí
  /**
   * It returns the encoding
   */

  //TODO Add result type to this method
  getTranslationModels$(imageID: number) {
    const url = `classifierModels/translator/${imageID}`;
    return this.apiRestClientService.get$(url);
  }




}
