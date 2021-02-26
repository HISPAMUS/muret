import {ApiRestClientService} from "../../../core/services/api-rest-client.service";
import {Injectable} from "@angular/core";
import {ImageOverview} from "../../../core/model/restapi/image-overview";
import {Observable} from "rxjs";
import {Page} from "../../../core/model/entities/page";

@Injectable() // non-singleton
export class ImageOverviewService {
  constructor(private apiRestClientService: ApiRestClientService) {
  }

  getImageOverview$(imageID: number): Observable<ImageOverview> {
    const url = `imageRecognition/overview/${imageID}`;
    return this.apiRestClientService.get$<ImageOverview>(url);
  }

  /**
   * It returns pages with region information
   * @param imageID
   */
  getPagesRegionsSymbols$(imageID: number): Observable<Page[]> {
    const url = `imageRecognition/pagesRegionsSymbols/${imageID}`
    return this.apiRestClientService.get$<Page[]>(url);
  }


  /**
   * It returns the comments set
   */
  putComments$(imageID: number, comments: string): Observable<String> {
    const url = `imageRecognition/comments/${imageID}`
    return this.apiRestClientService.put$<String>(url, comments);
  }

}
