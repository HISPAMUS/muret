import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbButtonsModule, NgbCollapseModule, NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from 'src/app/shared/shared.module';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { AdminDashboardRoutingModule } from './admin-dashboard-routing.module';
import { RegisterComponent } from './components/register/register.component';
import { StoreModule } from '@ngrx/store';
import { adminDBReducers } from './store/reducers/admindb.reducer';
import { EffectsModule } from '@ngrx/effects';
import { admindbeffects } from './store/effects/admindb.effects';
import { RegisterModelComponent } from './components/registermodel/register-model.component';
import { FileUploadModule } from 'ng2-file-upload';
import { PermissionsComponent } from './components/permissions/permissions.component';


@NgModule({
  declarations: [AdminDashboardComponent, RegisterComponent, RegisterModelComponent, PermissionsComponent],
  imports: [
    CommonModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    FileUploadModule,
    NgbButtonsModule,
    NgbCollapseModule,
    NgbTooltipModule,
    SharedModule,
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
