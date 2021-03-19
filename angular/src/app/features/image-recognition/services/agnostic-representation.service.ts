import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Observable} from 'rxjs';
import {Region} from '../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../core/model/entities/agnostic-symbol';
import {BoundingBox} from '../../../core/model/entities/bounding-box';
import {Point} from '../../../core/model/entities/point';
import {ClassifierModel} from '../../../core/model/entities/classifier-model';
import {SymbolCreationResult} from "../../agnostic-representation/model/symbol-creation-result";
import {SVGSet} from "../../agnostic-representation/model/svgset";
import {NumberArray} from "../../../core/model/restapi/number-array";

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

  // revisado hasta aquí
  deleteSymbol$(symbolID: number): Observable<number> {
    return this.apiRestClientService.delete$<number>('agnostic/deleteSymbol', symbolID);
  }


  getRegion$(regionID: number): Observable<Region> {
    return this.apiRestClientService.getProjectionOf$<Region>(regionID, 'regions', 'regionWithSymbols');
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



  /*classifySymbolFromBoundingBox$(regionID: number, boundingBox: BoundingBox, agnosticOrSemanticSymbolType: string):
  Observable<AgnosticOrSemanticSymbolAndPosition[]> {
    const symbolCreation = {
      regionID,
      agnosticOrSemanticSymbolType,
      boundingBox
    };

    return this.apiRestClientService.post$<AgnosticOrSemanticSymbolAndPosition[]>('agnostic/classifySymbolFromBoundingBox', symbolCreation);
  }

  classifySymbolFromStrokes$(regionID: number, points: Point[][], agnosticOrSemanticSymbolType: string): Observable<AgnosticOrSemanticSymbolAndPosition[]> {
    const symbolCreation = {
      regionID,
      agnosticOrSemanticSymbolType,
      points
    };

    return this.apiRestClientService.post$<AgnosticOrSemanticSymbolAndPosition[]>('agnostic/classifySymbolFromStrokes', symbolCreation);
  }*/



  /*getSymbolClassifierModel$(collectionID: number, documentID: number,
                            notationType: string, manuscriptType: string): Observable<ClassifierModel[]> {
    const url = `classifierModels/symbols/${collectionID}/${documentID}/${notationType}/${manuscriptType}`;
    return this.apiRestClientService.get$<ClassifierModel[]>(url);
  }*/
  getSymbolClassifierModel$(imageID: number): Observable<ClassifierModel[]> {
    const url = `classifierModels/symbols/${imageID}`;
    return this.apiRestClientService.get$<ClassifierModel[]>(url);
  }

  /* getAgnosticEnd2EndClassifierModel$(collectionID: number, documentID: number,
                                     notationType: string, manuscriptType: string): Observable<ClassifierModel[]> {
    const url = `classifierModels/agnosticEnd2End/${collectionID}/${documentID}/${notationType}/${manuscriptType}`;
    return this.apiRestClientService.get$<ClassifierModel[]>(url);
  } */
  getAgnosticEnd2EndClassifierModel$(imageID: number): Observable<ClassifierModel[]> {
    const url = `classifierModels/agnosticEnd2End/${imageID}`;
    return this.apiRestClientService.get$<ClassifierModel[]>(url);
  }

}
