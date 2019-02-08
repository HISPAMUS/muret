import { Component, OnInit } from '@angular/core';
import {Im3wsService} from '../../services/im3ws.service';
import {Router} from '@angular/router';

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

  constructor(private im3WSService: Im3wsService, private router: Router) {
  }
  authenticated(): boolean {
    return this.im3WSService.authService.authenticated();
  }

  hideLogo(): boolean {
    return this.hideLogoIn.has(this.router.url);
  }

  getUserName(): string {
    if (this.im3WSService.authService.authenticated()) {
      return this.im3WSService.authService.getUser().username;
    } else {
      return '';
    }

  }
}
