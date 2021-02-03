import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment'
import { NGXLogger } from 'ngx-logger';
import { NewUser } from '../model/new-user';
import {Permissions} from '../model/permissions'

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

@Injectable({providedIn:'root'})
export class AdminDBService
{
    registeruserURL = environment.apiEndpoint + '/users/register'
    revokepermissionsURL = environment.apiEndpoint + '/users/revokePermissions'
    grantpermissionsURL = environment.apiEndpoint + '/users/grantPermissions'


    constructor(private httpClient: HttpClient, private logger: NGXLogger){}

    attemptRegister$(registerdata : NewUser)
    {
        this.logger.debug('AdminDBService#post ' + this.registeruserURL)
        return this.httpClient.post(this.registeruserURL, registerdata, httpOptions)
    }

    revokePermissions$(permissionsForm: Permissions)
    {
        this.logger.debug('AdminDBService#post' + this.revokepermissionsURL)
        return this.httpClient.post(this.revokepermissionsURL, permissionsForm, httpOptions)

    }

    grantPermissions$(permissionsForm: Permissions)
    {
        this.logger.debug('AdminDBService#post' + this.grantpermissionsURL)
        return this.httpClient.post(this.grantpermissionsURL, permissionsForm, httpOptions)
    }
}
