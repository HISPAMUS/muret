import { Component, OnInit } from '@angular/core';

import {ResetPWD} from '../../models/resetpwd'
import { DialogsService } from 'src/app/shared/services/dialogs.service';

@Component({
  selector: 'app-resetpwd',
  templateUrl: './resetpwd.component.html',
  styleUrls: ['./resetpwd.component.css']
})
export class ResetpwdComponent implements OnInit {

  resetpwd: ResetPWD = {}
  repeatpwd: string

  constructor(private modalService: DialogsService) 
  { }

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
    console.log(this.resetpwd.username)
  }

}
