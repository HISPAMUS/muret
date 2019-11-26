import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import { ResetpwdComponent } from './components/resetpwd/resetpwd.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'resetpwd', component: ResetpwdComponent}
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
