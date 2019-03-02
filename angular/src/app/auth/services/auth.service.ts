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
  loginUrl = environment.apiEndpoint + '/auth/login';

  constructor(private http: HttpClient) {
  }

  attemptAuth$(credentials: Credentials): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  logout() {
  }

  getToken(): string {
    const result = sessionStorage.getItem('token');
    return result;
  }
}
