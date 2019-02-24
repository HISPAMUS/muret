import {Component, isDevMode, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {Credentials} from '../../models/credentials';
import {TokenStorageService} from '../../services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  protected credentials: Credentials = {};
  roles: string[] = [];

  isLoginFailed = false;
  errorMessage = '';
  isDev = isDevMode();

  constructor(protected authService: AuthService, protected router: Router, protected tokenStorage: TokenStorageService) {
  }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
    }
  }

  loginTo(url: string) {
    this.authService.attemptAuth(this.credentials).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);

        this.isLoginFailed = false;
        this.authService.isLoggedIn = true;
        this.authService.userID = data.userID;
        this.roles = this.tokenStorage.getAuthorities();
        this.router.navigateByUrl(url);
      },
      error => {
        this.errorMessage = error.error.message;
        this.authService.isLoggedIn = false;
      }
    );
  }
  login() {
    this.loginTo('/home');
  }

  dev() {
    this.credentials.username = 'davidrizo';
    this.credentials.password = 'nose';
    // this.loginTo('/project/148');
    this.loginTo('/documentanalysis/2104');
  }


  authenticated() {
    return this.authService.isLoggedIn;
  }

  logout() {
    this.authService.logout(() => {
      this.router.navigateByUrl('/about');
    });
    return false;
  }
}
