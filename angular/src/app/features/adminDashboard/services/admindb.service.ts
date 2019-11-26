import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment'
import { NGXLogger } from 'ngx-logger';
import { NewUser } from '../models/newusermodel';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

@Injectable({providedIn:'root'})
export class AdminDBService
{
    registeruserURL = environment.apiEndpoint + '/users/register'

    constructor(private httpClient: HttpClient, private logger: NGXLogger){}

    attemptRegister$(registerdata : NewUser)
    {
        this.logger.debug('AdminDBService#post ' + this.registeruserURL)
        return this.httpClient.post(this.registeruserURL, registerdata, httpOptions)
    }
}