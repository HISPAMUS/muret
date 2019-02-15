import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {RouterModule} from "@angular/router";
import {LayoutComponent} from "./components/ui/layout/layout.component";
import {HeaderComponent} from "./components/ui/header/header.component";
import {FooterComponent} from "./components/ui/footer/footer.component";
import {MessagesComponent} from "./components/messages/messages.component";

@NgModule({
  imports: [
    CommonModule, NgbModule, RouterModule // important to include the router module here because routes do not work otherwise
  ],
  exports: [LayoutComponent],
  declarations: [LayoutComponent, HeaderComponent, FooterComponent,
    MessagesComponent]
})

export class LayoutModule { }
