import { Component } from '@angular/core';
import { Router,
  NavigationExtras } from '@angular/router';
import {RestClientService} from '../services/rest-client.service';
import {NGXLogger} from 'ngx-logger';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  message: string;
  model: any = {
    'username': '',
    'password': ''
  };

  constructor(private authService: AuthService, private router: Router, private logger: NGXLogger) {
    this.setMessage();
  }

  setMessage() {
   /* if (this.im3WSService.authenticated()) {
      this.message = 'Logged in as ' + this.im3WSService.getUser().username;
    } else {
      this.message = 'Logged out';
    } */

  }

  // TODO Refactorizar
  login() {
    this.logger.debug('Loging in');
    this.message = 'Trying to log in ...';

    this.authService.login(this.model.username, this.model.password).subscribe(next => {
      this.authService.setUser(next);

      this.setMessage();
      if (this.authService.authenticated()) {
        const redirect = 'startup';
        // Redirect the user
        this.router.navigate([redirect]);
      }
    });
  }

  logout() {
    this.logger.debug('Logging out');
    this.authService.logout();
    this.setMessage();
  }

  isLoggedIn(): boolean {
    return this.authService.authenticated();
  }
}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/
