import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import { ResetPasswordComponent } from './components/resetpwd/reset-password.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'resetpwd', component: ResetPasswordComponent}
];

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class AuthRoutingModule {}
