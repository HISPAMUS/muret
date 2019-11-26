import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Observable} from 'rxjs';
import {Region} from '../../../core/model/entities/region';
import {SVGSet} from '../model/svgset';
import {AgnosticSymbol} from '../../../core/model/entities/agnosticSymbol';
import {BoundingBox} from '../../../core/model/entities/bounding-box';
import {Point} from '../../../core/model/entities/point';
import {AgnosticSymbolAndPosition} from '../model/agnostic-symbol-and-position';
import {SymbolCreationResult} from '../model/symbol-creation-result';
import {ClassifierModel} from '../../../core/model/entities/classifier-model';

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

  changeSymbolComments$(symbol: AgnosticSymbol, comments: string) {
    const params = {
      id: symbol.id,
      comments
    };
    return this.apiRestClientService.put$<AgnosticSymbol>('agnostic/symbolCommentsUpdate', params);
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

  /*classifySymbolFromBoundingBox$(regionID: number, boundingBox: BoundingBox, agnosticSymbolType: string):
  Observable<AgnosticSymbolAndPosition[]> {
    const symbolCreation = {
      regionID,
      agnosticSymbolType,
      boundingBox
    };

    return this.apiRestClientService.post$<AgnosticSymbolAndPosition[]>('agnostic/classifySymbolFromBoundingBox', symbolCreation);
  }

  classifySymbolFromStrokes$(regionID: number, points: Point[][], agnosticSymbolType: string): Observable<AgnosticSymbolAndPosition[]> {
    const symbolCreation = {
      regionID,
      agnosticSymbolType,
      points
    };

    return this.apiRestClientService.post$<AgnosticSymbolAndPosition[]>('agnostic/classifySymbolFromStrokes', symbolCreation);
  }*/


  deleteSymbol$(symbolID: number): Observable<number> {
    return this.apiRestClientService.delete$<number>('agnostic/deleteSymbol', symbolID);
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

  /*getSymbolClassifierModel$(collectionID: number, projectID: number,
                            notationType: string, manuscriptType: string): Observable<ClassifierModel[]> {
    const url = `classifierModels/symbols/${collectionID}/${projectID}/${notationType}/${manuscriptType}`;
    return this.apiRestClientService.get$<ClassifierModel[]>(url);
  }*/
  getSymbolClassifierModel$(imageID: number): Observable<ClassifierModel[]> {
    const url = `classifierModels/symbols/${imageID}`;
    return this.apiRestClientService.get$<ClassifierModel[]>(url);
  }

  /* getAgnosticEnd2EndClassifierModel$(collectionID: number, projectID: number,
                                     notationType: string, manuscriptType: string): Observable<ClassifierModel[]> {
    const url = `classifierModels/agnosticEnd2End/${collectionID}/${projectID}/${notationType}/${manuscriptType}`;
    return this.apiRestClientService.get$<ClassifierModel[]>(url);
  } */
  getAgnosticEnd2EndClassifierModel$(imageID: number): Observable<ClassifierModel[]> {
    const url = `classifierModels/agnosticEnd2End/${imageID}`;
    return this.apiRestClientService.get$<ClassifierModel[]>(url);
  }

}
