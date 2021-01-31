import { Component, OnInit } from '@angular/core';

import {ResetPWD} from '../../models/resetpwd'
import { DialogsService } from 'src/app/shared/services/dialogs.service';
import { AuthState } from '../../store/state/auth.state';
import { Store } from '@ngrx/store';
import { AuthResetPassword } from '../../store/actions/auth.actions';
import { Subscription } from 'rxjs';
import { selectAuthResetPWDStatus } from '../../store/selectors/auth.selector';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  resetpwd: ResetPWD = {}
  repeatpwd: string
  pwdresetmsg: Subscription

  constructor(private modalService: DialogsService, private store: Store<AuthState>)
  {
    this.pwdresetmsg = store.select(selectAuthResetPWDStatus).subscribe((number)=>{
      if(number == 1)
        this.modalService.showConfirmation("Success", "Password reseted correctly")
      else if(number == -1)
        this.modalService.showError("Error", "The user does not exist", "There was an error resetting the password")
    })
  }

  ngOnInit() {
  }

  resetPassword()
  {
    if(this.resetpwd.newPWD != this.repeatpwd)
    {
      this.modalService.showError("Fatal error", `This error happens because you have introduced worng the password in the New Password field and the Repeat Password field.
      Please be careful with it`, "The passwords submitted do not match")
      return;
    }

    this.store.dispatch(new AuthResetPassword(this.resetpwd));
  }

}
