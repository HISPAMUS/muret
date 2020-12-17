import { Injectable } from '@angular/core';
import {ApiRestClientService} from './api-rest-client.service';
import {User} from '../model/entities/user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getUserProjection$(userID: number): Observable<User> {
    return this.apiRestClientService.getExcerptProjectionOf$<User>(userID, 'users');
  }

  public getUsersPermissions$():Observable<any>{
    return this.apiRestClientService.get$<any>('users/userPermissions')
  }

  public getAllUsers():Observable<string[]>{
    return this.apiRestClientService.get$<string[]>('users/allUsers')
  }
}
