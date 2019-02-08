import { Injectable } from '@angular/core';
import {User} from '../model/user';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {NGXLogger} from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private SESSION_USER_STORAGE = 'token';

  private user: User;
  private urlLogin: string;
  private urlAuthenticatedUser: string;
  private urlUser: string;

  constructor(private http: HttpClient,
              private logger: NGXLogger) {
    this.urlLogin = environment.apiEndpoint + '/auth/login';  // URL to web api
    this.urlAuthenticatedUser = environment.apiEndpoint + '/auth/user';
    this.urlUser = environment.apiEndpoint + '/user';
  }

  logout(): void {
    // return this.im3wsService.logout();
    //  this.isLoggedIn = false;
    this.user = null;
    sessionStorage.removeItem(this.SESSION_USER_STORAGE);
  }

  public authenticated(): boolean {
    // return this.isLoggedIn;
    return this.user != null;
  }

  public getUser(): User {
    return this.user;
  }


  public login(username: string, password: string): Observable<User> {
    return this.http.post<User>(this.urlLogin, {
      username: username,
      password: password
    }); /*.pipe(
      tap<User>(next => {
        if (next != null) {
          sessionStorage.setItem(
            this.SESSION_USER_STORAGE,
            btoa(username + ':' + password)
          );
          this.logger.error('Found user with id=' + next.id);
          Object.assign(this.user, next);
        }
      })
    );*/
  }

  public getHttpAuthOptions() {
    const token = sessionStorage.getItem(this.SESSION_USER_STORAGE);
    if (!token) {
      throw new Error('User is not authorized yet');
    }

    const headers: HttpHeaders = new HttpHeaders({
      'Authorization': 'Bearer ' + token
    });
    const options = {headers: headers};
    return options;


    /*const headers_object = new HttpHeaders();
    headers_object.append('Content-Type', 'application/json');
    headers_object.append('Authorization', 'Basic ' + btoa('username:password'));
    headers_object.append('Access-Control-Allow-Methods', 'GET, POST, DELETE, PUT');

    const httpOptions = {
      headers: headers_object
    };
    return httpOptions;*/
  }

  checkAuthorized() {
    this.http.post<Observable<Object>>(this.urlAuthenticatedUser, {}, this.getHttpAuthOptions()).
    subscribe(principal => {
        this.logger.log('Current user: ' + principal['name']);
      },
      error => {
        if (error.status === 401) {
          alert('Unauthorized');
        }
      }
    );
  }

  /*this.http.post<Observable<boolean>>(this.urlLogin, {
    username: username,
    password: password
  }).subscribe(isValid => {
    if (isValid) {
      sessionStorage.setItem(
        'token',
        btoa(username + ':' + password)
      );
      // router.navigate(['']);
      return true;
    } else {
      // alert('Authentication failed.');
      return false;
    }
  });*/




  setUser(u: User) {
    this.user = Object.assign(new User(), u);

    sessionStorage.setItem(
      this.SESSION_USER_STORAGE,
      btoa(this.user.username)
    );
    this.logger.debug('ID: ' + this.user.id);
  }

}
