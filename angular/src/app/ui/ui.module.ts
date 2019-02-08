import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout/layout.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MessagesComponent } from '../messages/messages.component';
import {RouterModule} from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  imports: [
    CommonModule, NgbModule, RouterModule // important to include the router module here because routes do not work otherwise
  ],
  exports: [LayoutComponent],
  declarations: [LayoutComponent, HeaderComponent, FooterComponent,
    MessagesComponent]
})
export class UiModule { }
