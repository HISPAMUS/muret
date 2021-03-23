import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ApiRestClientService} from "./api-rest-client.service";
import {SVGSet} from "../model/restapi/svgset";

@Injectable({
  providedIn: 'root'
})
export class FontsService {
  // it maintains a single copy of each font set
  svgSets: Map<string, Observable<SVGSet>>; // key = manuscriptType + notationType

  constructor(private apiRestClientService: ApiRestClientService) {
    this.svgSets = new Map();
  }

  getSVGSet$(notationType: string, manuscriptType: string): Observable<SVGSet> {
    const key = notationType + manuscriptType;
    let result = this.svgSets.get(key);
    if (!result) {
      const url = `fonts/svgset?notationType=${notationType}&manuscriptType=${manuscriptType}`;
      result = this.apiRestClientService.get$<SVGSet>(url);
      this.svgSets.set(key, result);
    }
    return result;
  }
}
