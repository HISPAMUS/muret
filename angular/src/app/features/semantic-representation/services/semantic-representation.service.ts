import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Observable} from 'rxjs';
import {AgnosticSymbol} from '../../../core/model/entities/agnosticSymbol';
import {Region} from '../../../core/model/entities/region';
import {Notation} from './notation';

@Injectable()
export class SemanticRepresentationService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  /**
   * It returns the MEI encoding
   */
  agnostic2Semantic$(region: Region, mensustriche: boolean, renderer: 'verovio' | 'im3'): Observable<Notation> {
    const url = `semantic/agnostic2semantic/${region.id}/${mensustriche}/${renderer}`;
    return this.apiRestClientService.get$<Notation>(url);

  }

  /**
   * It returns the MEI encoding
   */
  getNotation$(region: Region): Observable<Notation> {
    throw new Error('Not implemented getNotation$');
  }

}
