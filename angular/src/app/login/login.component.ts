import { Component } from '@angular/core';
import { Router,
  NavigationExtras } from '@angular/router';
import {Im3wsService} from '../services/im3ws.service';
import {NGXLogger} from 'ngx-logger';

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

  constructor(private im3WSService: Im3wsService, private router: Router, private logger: NGXLogger) {
    this.setMessage();
  }

  setMessage() {
   /* if (this.im3WSService.authenticated()) {
      this.message = 'Logged in as ' + this.im3WSService.getUser().username;
    } else {
      this.message = 'Logged out';
    } */

  }

  login() {
    this.logger.debug('Loging in');
    this.message = 'Trying to log in ...';

    this.im3WSService.authService.login(this.model.username, this.model.password).subscribe(next => {
      this.im3WSService.authService.setUser(next);

      this.setMessage();
      if (this.im3WSService.authService.authenticated()) {
        const redirect = 'startup';
        // Redirect the user
        this.router.navigate([redirect]);
      }
    });
  }

  logout() {
    this.logger.debug('Logging out');
    this.im3WSService.authService.logout();
    this.setMessage();
  }

  isLoggedIn(): boolean {
    return this.im3WSService.authService.authenticated();
  }
}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/
