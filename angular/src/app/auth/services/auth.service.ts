import { Injectable } from '@angular/core';
import {Credentials} from '../models/credentials';
import {Observable} from 'rxjs';
import {JwtResponse} from '../models/jwt-response';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

// singleton shared across all the application
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = false;
  // store the URL so we can redirect after logging in
  redirectUrl: string;
  loginUrl = environment.apiEndpoint + '/auth/login';
  userID: number;

  constructor(private http: HttpClient) {
  }

  attemptAuth(credentials: Credentials): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  /*authenticate(credentials, callback) {
    const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get('user', {headers}).subscribe(response => {
      if (response.name) {
        this.isLoggedIn = true;
      } else {
        this.isLoggedIn = false;
      }
      return callback && callback();
    });
  }*/

  logout(callback) {
    this.isLoggedIn = false;
    this.userID = null;
    return callback && callback();
  }
}
