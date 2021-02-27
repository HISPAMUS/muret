import {ApiRestClientService} from "../../../core/services/api-rest-client.service";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {PartLinking} from "../../../core/model/restapi/part-linking";
import {Page} from "../../../core/model/entities/page";
import {PagesRegionsSymbolsAndNewPart} from "../../../core/model/restapi/pages-regions-symbols-and-new-part";
import {Part} from "../../../core/model/entities/part";

@Injectable() // non-singleton
export class ImagePartsService {
  constructor(private apiRestClientService: ApiRestClientService) {
  }

  linkToPart$(payload: PartLinking): Observable<Page[]> {
    const url = `parts/linkToPart`;
    return this.apiRestClientService.put$<Page[]>(url, payload);
  }
  linkToNewPart$(payload: PartLinking): Observable<PagesRegionsSymbolsAndNewPart>  {
    const url = `parts/linkToNewPart`;
    return this.apiRestClientService.post$<PagesRegionsSymbolsAndNewPart>(url, payload);
  }

  unlinkFromPart$(payload: PartLinking): Observable<Page[]> {
    const url = `parts/unlinkPart`;
    return this.apiRestClientService.put$<Page[]>(url, payload);
  }

  linkImageToPart$(imageID: number, partID: number): Observable<Part> {
    const url = `parts/linkImageToPart/${imageID}/${partID}`;
    return this.apiRestClientService.put$<Part>(url, null);
  }

  linkImageToNewPart$(imageID: number, partName: string): Observable<Part>  {
    const url = `parts/linkImageToNewPart/${imageID}`;
    return this.apiRestClientService.post$<Part>(url, partName);
  }

  unlinkImageFromPart$(imageID: number) {
    const url = `parts/unlinkImageFromPart/${imageID}`;
    return this.apiRestClientService.put$(url, null);
  }
}
