import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Observable} from 'rxjs';
import {Region} from '../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../core/model/entities/agnostic-symbol';
import {BoundingBox} from '../../../core/model/entities/bounding-box';
import {Point} from '../../../core/model/entities/point';
import {ClassifierModel} from '../../../core/model/entities/classifier-model';
import {NumberArray} from "../../../core/model/restapi/number-array";
import {SVGSet} from "../../../core/model/restapi/svgset";
import {SymbolCreationResult} from "../../agnostic-representation-old/model/symbol-creation-result";

@Injectable()
export class AgnosticRepresentationService {
  svgSets: Map<string, Observable<SVGSet>>; // key = manuscriptType + notationType

  constructor(private apiRestClientService: ApiRestClientService) {
    this.svgSets = new Map();
  }

  createSymbolFromBoundingBox$(modelID: string, regionID: number, boundingBox: BoundingBox, agnosticSymbolType: string,
                               positionInStaff: string):
    Observable<SymbolCreationResult> {
    const symbolCreation = {
      modelID,
      regionID,
      agnosticSymbolType,
      positionInStaff,
      boundingBox
    };
    return this.apiRestClientService.post$<SymbolCreationResult>('agnostic/createSymbolFromBoundingBox', symbolCreation);
  }

  createSymbolFromStrokes$(modelID: string, regionID: number, points: Point[][], agnosticSymbolType: string, positionInStaff: string):
    Observable<SymbolCreationResult> {
    const symbolCreation = {
      modelID,
      regionID,
      agnosticSymbolType,
      positionInStaff,
      points
    };

    return this.apiRestClientService.post$<SymbolCreationResult>('agnostic/createSymbolFromStrokes', symbolCreation);
  }

  deleteSymbols$(symbols: AgnosticSymbol[]): Observable<NumberArray> {
    const symbolIDs: NumberArray = {
      values: []
    };
    symbols.forEach(s => {
      symbolIDs.values.push(s.id);
    });
    return this.apiRestClientService.post$<NumberArray>('agnostic/deleteSymbols', symbolIDs);
  }

  classifyRegionEndToEnd$(modelID: string, regionID: number): Observable<AgnosticSymbol[]> {
    const url = `agnostic/classifyRegionEndToEnd/${modelID}/${regionID}`;
    return this.apiRestClientService.get$<AgnosticSymbol[]>(url);
  }

  clearRegionSymbols$(regionID: number): Observable<boolean> {
    if (regionID) { // TODO It's invoked twice !!
      return this.apiRestClientService.delete$<boolean>('agnostic/clearRegionSymbols', regionID);
    }
  }

  changeSymbol$(agnosticSymbol: AgnosticSymbol, agnosticSymbolType: string, positionInStaff: string): Observable<AgnosticSymbol> {
    const url = `agnostic/changeAgnosticSymbol/${agnosticSymbol.id}/${agnosticSymbolType}/${positionInStaff}`;
    return this.apiRestClientService.get$<AgnosticSymbol>(url);

  }

  changeSymbolBoundingBox$(symbol: AgnosticSymbol, fromX: number, fromY: number, toX: number, toY: number): Observable<AgnosticSymbol> {
    // console.log('Ey')
    const boundingBox: BoundingBox = {
      id: symbol.id,
      fromX,
      fromY,
      toX,
      toY
    };
    return this.apiRestClientService.put$<AgnosticSymbol>('agnostic/symbolBoundingBoxUpdate', boundingBox);
  }

  changeSymbolComments$(symbol: AgnosticSymbol, comments: string): Observable<AgnosticSymbol> {
    const params = {
      id: symbol.id,
      comments
    };
    return this.apiRestClientService.put$<AgnosticSymbol>('agnostic/symbolCommentsUpdate', params);
  }

  changeRegionExternalReference$(region: Region, externalReference: string): Observable<Region> {
    const params = {
      value: externalReference
    };
    const url = `agnostic/regionExternalReferenceUpdate/${region.id}`;
    return this.apiRestClientService.post$<AgnosticSymbol>(url, params);

  }

  changeSymbolX$(symbol: AgnosticSymbol, newX: number): Observable<AgnosticSymbol> {
    const intX = ~~newX; // cast to int
    const url = `agnostic/changeSymbolX/${symbol.id}/${intX}`;
    return this.apiRestClientService.post$<AgnosticSymbol>(url, null);

  }
  ImageRecognitionChangeSymbolXSuccess
}
