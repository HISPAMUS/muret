import { Injectable } from '@angular/core';
import {
  CanActivate, Router,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  CanActivateChild,
  NavigationExtras,
  CanLoad, Route, CanDeactivate
} from '@angular/router';
import {RestClientService} from '../services/rest-client.service';
import {NGXLogger} from 'ngx-logger';
import {SessionDataService} from '../services/session-data.service';
import {Observable} from 'rxjs';
import {ComponentCanDeactivate} from './component-can-deactivate';
import {AuthService} from "../services/auth.service";

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate, CanActivateChild, CanLoad, CanDeactivate<ComponentCanDeactivate> {
  constructor(private authService: AuthService, private sessionDataService: SessionDataService, private router: Router,
              private logger: NGXLogger) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const url: string = state.url;
    this.logger.debug('Checking canActivate for ' + url);
    return this.checkLogin(url);
  }

  canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    return this.canActivate(route, state);
  }

  canLoad(route: Route): boolean {
    this.logger.debug('Check can load ' + route.path);
    const url = `/${route.path}`;

    return this.checkLogin(url);
  }

  checkLogin(url: string): boolean {
    if (this.authService.authenticated()) {
      this.logger.debug('Can activate ' + url);
      return true;
    }

    this.logger.debug('Cannot activate ' + url);

    // Create a dummy session id
    const sessionId = this.getRandomInt(1, 1000000);

    // Set our navigation extras object
    // that contains our global query params and fragment
    const navigationExtras: NavigationExtras = {
      queryParams: { 'session_id': sessionId },
      fragment: 'anchor'
    };

    // Navigate to the login page with extras
    this.router.navigate(['login'], navigationExtras);
    return false;
  }

  getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  canDeactivate(component: ComponentCanDeactivate, currentRoute: ActivatedRouteSnapshot,
                currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (component.canDeactivate()) {
      if (confirm('You have unsaved changes! If you leave, your changes will be lost.')) {
        return true;
      } else {
        return false;
      }
    }
    return true;
  }
}
