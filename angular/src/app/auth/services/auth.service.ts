import { Injectable } from '@angular/core';
import {Credentials} from '../models/credentials';
import {Observable} from 'rxjs';
import {JwtResponse} from '../models/jwt-response';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {NGXLogger} from 'ngx-logger';
import { ResetPWD } from '../models/resetpwd';
import { StringResponse } from 'src/app/core/model/restapi/string-response';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

// singleton shared across all the application
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loginUrl = environment.apiEndpoint + '/auth/login';
  resetpwdUrl = environment.apiEndpoint + '/users/resetpwd'

  constructor(private http: HttpClient, private logger: NGXLogger) {
  }

  attemptAuth$(credentials: Credentials): Observable<JwtResponse> {
    this.logger.debug('AuthService#post ' + this.loginUrl);
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  resetPassword$(resetpwd: ResetPWD): Observable<StringResponse> {
    this.logger.debug('AuthService#post' + this.resetpwdUrl)
    return this.http.post<StringResponse>(this.resetpwdUrl, resetpwd, httpOptions);
  }
}
