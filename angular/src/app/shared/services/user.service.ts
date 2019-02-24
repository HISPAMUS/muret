import { Injectable } from '@angular/core';
import {AuthService} from '../../auth/services/auth.service';
import {ApiRestClientService} from './api-rest-client.service';
import {User} from '../entities/user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private authService: AuthService, private apiRestClientService: ApiRestClientService) { }

  public getCurrentUserProjection(): Observable<User> {
    return this.apiRestClientService.getExcerptProjectionOf$<User>(this.authService.userID, 'users');
  }
}
