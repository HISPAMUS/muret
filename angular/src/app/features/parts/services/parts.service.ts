import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Region} from '../../../core/model/entities/region';
import {Image} from '../../../core/model/entities/image';
import {Part} from '../../../core/model/entities/part';
import {Observable} from 'rxjs';
import {Page} from '../../../core/model/entities/page';
import {AgnosticSymbol} from '../../../core/model/entities/agnosticSymbol';


@Injectable()
export class PartsService {

  constructor(private apiRestClientService: ApiRestClientService) {
  }

  public getImagePart$(id: number): Observable<Part> {
    const url = 'parts/get/image/' + id;
    return this.apiRestClientService.get$<Part>(url);
  }

  public getPagePart$(id: number): Observable<Part> {
    const url = 'parts/get/page/' + id;
    return this.apiRestClientService.get$<Part>(url);
  }

  public getRegionPart$(id: number): Observable<Part> {
    const url = 'parts/get/region/' + id;
    return this.apiRestClientService.get$<Part>(url);
  }

  public getSymbolPart$(id: number): Observable<Part> {
    const url = 'parts/get/symbol/' + id;
    return this.apiRestClientService.get$<Part>(url);
  }

  updateImagePart$(image: Image, part: Part): Observable<Image> {
    if (part == null) {
      return this.apiRestClientService.put$<Image>('parts/clear/image/' + image.id, null);
    } else {
      return this.apiRestClientService.put$<Image>('parts/set/image/' + image.id + '/' + part.id, null);
    }
  }

  updatePagePart$(page: Page, part: Part): Observable<Page> {
    if (part == null) {
      return this.apiRestClientService.put$<Page>('parts/clear/page/' + page.id, null);
    } else {
      return this.apiRestClientService.put$<Page>('parts/set/page/' + page.id + '/' + part.id, null);
    }
  }

  updateRegionPart$(region: Region, part: Part): Observable<Region> {
    if (part == null) {
      return this.apiRestClientService.put$<Region>('parts/clear/region/' + region.id, null);
    } else {
      return this.apiRestClientService.put$<Region>('parts/set/region/' + region.id + '/' + part.id, null);
    }
  }

  updateSymbolPart$(symbol: AgnosticSymbol, part: Part): Observable<AgnosticSymbol> {
    if (part == null) {
      return this.apiRestClientService.put$<AgnosticSymbol>('parts/clear/symbol/' + symbol.id, null);
    } else {
      return this.apiRestClientService.put$<AgnosticSymbol>('parts/set/page/' + symbol.id + '/' + part.id, null);
    }
  }

  createImagePart$(image: Image, partName: string): Observable<Image> {
    return this.apiRestClientService.put$<Image>('parts/create/image/' + image.id + '/' + partName, null);
  }

  createPagePart$(page: Page, partName: string): Observable<Page> {
    return this.apiRestClientService.put$<Page>('parts/create/page/' + page.id + '/' + partName, null);
  }

  createRegionPart$(region: Region, partName: string): Observable<Region> {
    return this.apiRestClientService.put$<Region>('parts/create/region/' + region.id + '/' + partName, null);
  }

  createSymbolPart$(symbol: AgnosticSymbol, partName: string): Observable<AgnosticSymbol> {
    return this.apiRestClientService.put$<AgnosticSymbol>('parts/create/page/' + symbol.id + '/' + partName, null);
  }
}
