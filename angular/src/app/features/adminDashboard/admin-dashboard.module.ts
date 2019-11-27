import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbButtonsModule, NgbCollapseModule, NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from 'src/app/shared/shared.module';
import { BreadcrumbModule } from 'src/app/breadcrumb/breadcrumb.module';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { AdminDashboardRoutingModule } from './admin-dashboard-routing.module';
import { RegisterComponent } from './components/register/register.component';
import { StoreModule } from '@ngrx/store';
import { adminDBReducers } from './store/reducers/admindb.reducer';
import { EffectsModule } from '@ngrx/effects';
import { admindbeffects } from './store/effects/admindb.effects';


@NgModule({
  declarations: [AdminDashboardComponent, RegisterComponent],
  imports: [
    CommonModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    NgbButtonsModule,
    NgbCollapseModule,
    NgbTooltipModule,
    SharedModule,
    BreadcrumbModule,
    AdminDashboardRoutingModule,
    StoreModule.forFeature('adminDB', adminDBReducers),
    EffectsModule.forFeature(admindbeffects)
  ],
  exports: [
  ],
  entryComponents: [
  ],
  providers: [
  ]
})
export class AdminDashboardModule { }