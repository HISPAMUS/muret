import { Component, OnInit } from '@angular/core';
import {RestClientService} from '../../../../services/rest-client.service';
import {Router} from '@angular/router';
import {AuthService} from "../../../../services/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  hideLogoIn = new Set([
    '/about',
    '/startup'
    ]);

  constructor(private authService: AuthService, private router: Router) {
  }
  authenticated(): boolean {
    return this.authService.authenticated();
  }

  hideLogo(): boolean {
    return this.hideLogoIn.has(this.router.url);
  }

  getUserName(): string {
    if (this.authService.authenticated()) {
      return this.authService.getUser().username;
    } else {
      return '';
    }

  }
}
