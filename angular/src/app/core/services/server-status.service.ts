import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { StringResponse } from '../model/restapi/string-response';
import {environment} from '../../../environments/environment'

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ServerStatusService {

  url = environment.apiEndpoint + "/statusControl"

  constructor(private httpclient: HttpClient) { }

  getServerStatus$()
  {
    return this.httpclient.get<StringResponse>(this.url + "/getStatus", httpOptions)
  }
}
