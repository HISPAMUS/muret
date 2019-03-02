import { Injectable } from '@angular/core';
import {AuthService} from '../../auth/services/auth.service';
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
}
