import { Injectable } from '@angular/core';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {Part} from '../../../core/model/entities/part';
import {Observable} from 'rxjs';
import {PartUse, UsesOfAllParts} from '../../../core/model/restapi/uses-of-all-parts';


@Injectable()
export class PartsService {

  constructor(private apiRestClientService: ApiRestClientService) {
  }

  /*getPartNamesUsedByImage$(imageID: number): Observable<string[]> {
    const url = 'parts/partNamesUsedByImage/' + imageID;
    return this.apiRestClientService.get$<string[]>(url);
  }*/

  createImagePart$(imageID: number, partName: string): Observable<PartUse> {
    return this.apiRestClientService.put$<PartUse>('parts/create/image/' + imageID + '/' + partName, null);
  }

  createPagePart$(pageID: number, partName: string): Observable<PartUse> {
    return this.apiRestClientService.put$<PartUse>('parts/create/page/' + pageID + '/' + partName, null);
  }

  createRegionPart$(regionID: number, partName: string): Observable<PartUse> {
    return this.apiRestClientService.put$<PartUse>('parts/create/region/' + regionID + '/' + partName, null);
  }


  /*getDocumentParts$(documentID: number): Observable<Part[]> {
    const url = 'parts/document/' + documentID;
    return this.apiRestClientService.get$<Part[]>(url);
  }

  getImageDocumentParts$(imageID: number) {
    const url = 'parts/imageDocumentParts/' + imageID;
    return this.apiRestClientService.get$<Part[]>(url);
  }*/

  /*public getImagePart$(id: number): Observable<Part> {
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

  updateImagePart$(image: Image, part: Part): Observable<Part> {
    if (part == null) {
      return this.apiRestClientService.put$<Part>('parts/clear/image/' + image.id, null);
    } else {
      return this.apiRestClientService.put$<Part>('parts/set/image/' + image.id + '/' + part.id, null);
    }
  }

  updatePagePart$(page: Page, part: Part): Observable<Part> {
    if (part == null) {
      return this.apiRestClientService.put$<Part>('parts/clear/page/' + page.id, null);
    } else {
      return this.apiRestClientService.put$<Part>('parts/set/page/' + page.id + '/' + part.id, null);
    }
  }

  updateRegionPart$(region: Region, part: Part): Observable<Part> {
    if (part == null) {
      return this.apiRestClientService.put$<Part>('parts/clear/region/' + region.id, null);
    } else {
      return this.apiRestClientService.put$<Part>('parts/set/region/' + region.id + '/' + part.id, null);
    }
  }

  updateSymbolPart$(symbol: AgnosticSymbol, part: Part): Observable<Part> {
    if (part == null) {
      return this.apiRestClientService.put$<Part>('parts/clear/symbol/' + symbol.id, null);
    } else {
      return this.apiRestClientService.put$<Part>('parts/set/page/' + symbol.id + '/' + part.id, null);
    }
  }

  createImagePart$(image: Image, partName: string): Observable<Part> {
    return this.apiRestClientService.put$<Part>('parts/create/image/' + image.id + '/' + partName, null);
  }

  createPagePart$(page: Page, partName: string): Observable<Part> {
    return this.apiRestClientService.put$<Part>('parts/create/page/' + page.id + '/' + partName, null);
  }

  createRegionPart$(region: Region, partName: string): Observable<Part> {
    return this.apiRestClientService.put$<Part>('parts/create/region/' + region.id + '/' + partName, null);
  }

  createSymbolPart$(symbol: AgnosticSymbol, partName: string): Observable<Part> {
    return this.apiRestClientService.put$<Part>('parts/create/page/' + symbol.id + '/' + partName, null);
  }*/

  createPart$(documentID: number, name: string): Observable<Part> {
    return this.apiRestClientService.put$<Part>('parts/create/' + documentID + '/' + name, null);
  }

  renamePart$(part: Part, newName: string): Observable<Part> {
    return this.apiRestClientService.put$<Part>('parts/rename/' + part.id + '/' + newName, null);
  }

  deletePart$(partID: number): Observable<number> {
    return this.apiRestClientService.delete$<number>('parts/delete', partID);
  }
  getUsesOfParts$(documentID: number): Observable<UsesOfAllParts> {
    const url = `parts/uses/${documentID}`;
    return this.apiRestClientService.get$<UsesOfAllParts>(url);
  }

  linkPartToImage$(partUse: PartUse): Observable<PartUse> {
    return this.apiRestClientService.put$<PartUse>('parts/link/' + partUse.partId + '/image/' + partUse.imageId, null);
  }

  unlinkPartToImage$(partUse: PartUse): Observable<PartUse> {
    return this.apiRestClientService.put$<PartUse>('parts/unlink/image/' + partUse.imageId, null);
  }

  linkPartToPage$(partUse: PartUse): Observable<PartUse> {
    return this.apiRestClientService.put$<PartUse>('parts/link/' + partUse.partId + '/page/' + partUse.id, null);
  }

  unlinkPartToPage$(partUse: PartUse): Observable<PartUse> {
    return this.apiRestClientService.put$<PartUse>('parts/unlink/page/' + partUse.id, null);
  }

  linkPartToRegion$(partUse: PartUse): Observable<PartUse> {
    return this.apiRestClientService.put$<PartUse>('parts/link/' + partUse.partId + '/region/' + partUse.id, null);
  }

  unlinkPartToRegion$(partUse: PartUse): Observable<PartUse> {
    return this.apiRestClientService.put$<PartUse>('parts/unlink/region/' + partUse.id, null);
  }


}
