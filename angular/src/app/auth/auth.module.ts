import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './components/login/login.component';
import {AuthRoutingModule} from './auth-routing.module';
import { FormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {TokenInterceptor} from './token-interceptor.service';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {authReducers} from './store/reducers/auth.reducers';
import {authEffects} from './store/effects/auth.effects';
import { ResetpwdComponent } from './components/resetpwd/resetpwd.component';

@NgModule({
  declarations: [LoginComponent, ResetpwdComponent],
  imports: [
    CommonModule,
    AuthRoutingModule,
    FormsModule,
    StoreModule.forFeature('auth', authReducers),
    EffectsModule.forFeature(authEffects),
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true} // provide interceptor along the application
  ]
})
export class AuthModule { }
