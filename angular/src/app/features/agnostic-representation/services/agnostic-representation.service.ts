import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Observable} from 'rxjs';
import {Region} from '../../../core/model/entities/region';
import {SVGSet} from '../model/svgset';
import {AgnosticSymbol} from '../../../core/model/entities/agnosticSymbol';
import {BoundingBox} from '../../../core/model/entities/bounding-box';
import {Point} from '../../../core/model/entities/point';

@Injectable()
export class AgnosticRepresentationService {
  svgSets: Map<string, Observable<SVGSet>>; // key = manuscriptType + notationType

  constructor(private apiRestClientService: ApiRestClientService) {
    this.svgSets = new Map();
  }

  getRegion$(regionID: number): Observable<Region> {
    return this.apiRestClientService.getProjectionOf$<Region>(regionID, 'regions', 'regionWithSymbols');
  }

  getSVGSet$(notationType: string, manuscriptType: string): Observable<SVGSet> {
    const key = notationType + manuscriptType;
    let result = this.svgSets.get(key);
    if (!result) {
      const url = `agnostic/svgset?notationType=${notationType}&manuscriptType=${manuscriptType}`;
      result = this.apiRestClientService.get$<SVGSet>(url);
      this.svgSets.set(key, result);
    }
    return result;
  }

  changeSymbolType$(agnosticSymbol: AgnosticSymbol, agnosticSymbolType: string): Observable<AgnosticSymbol> {
    const url = `agnostic/changeAgnosticSymbolType/${agnosticSymbol.id}/${agnosticSymbolType}`;
    return this.apiRestClientService.get$<AgnosticSymbol>(url);

  }

  changeSymbolPositionInStaff$(agnosticSymbol: AgnosticSymbol, difference: number): Observable<AgnosticSymbol> {
    const url = `agnostic/changeAgnosticPositionInStaff/${agnosticSymbol.id}/${difference}`;
    return this.apiRestClientService.get$<AgnosticSymbol>(url);
  }

  changeSymbolBoundingBox$(symbol: AgnosticSymbol, fromX: number, fromY: number, toX: number, toY: number): Observable<AgnosticSymbol> {
    const boundingBox: BoundingBox = {
      id: symbol.id,
      fromX,
      fromY,
      toX,
      toY
    };
    return this.apiRestClientService.put$<AgnosticSymbol>('agnostic/symbolBoundingBoxUpdate', boundingBox);
  }


  createSymbolFromBoundingBox$(regionID: number, boundingBox: BoundingBox, agnosticSymbolType: string): Observable<AgnosticSymbol> {
    const symbolCreation = {
      regionID,
      agnosticSymbolType,
      boundingBox
    };

    return this.apiRestClientService.post$<AgnosticSymbol>('agnostic/createSymbolFromBoundingBox', symbolCreation);
  }

  createSymbolFromStrokes$(regionID: number, points: Point[][], agnosticSymbolType: string): Observable<AgnosticSymbol> {
    const symbolCreation = {
      regionID,
      agnosticSymbolType,
      points
    };

    return this.apiRestClientService.post$<AgnosticSymbol>('agnostic/createSymbolFromStrokes', symbolCreation);
  }

  deleteSymbol$(symbolID: number): Observable<number> {
    return this.apiRestClientService.delete$<number>('agnostic/deleteSymbol', symbolID);
  }

}
