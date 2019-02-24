import {Component, isDevMode, OnInit} from '@angular/core';
import {AuthService} from '../../../auth/services/auth.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {
  private menuVisible = true;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  public authenticated() {
    return this.authService.isLoggedIn;
  }
}
