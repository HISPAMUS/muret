import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { NewUser } from '../../models/newusermodel';
import { AdminDashboardState } from '../../store/state/admindb.state';
import { Store } from '@ngrx/store';
import { Observable, Subscription } from 'rxjs';
import { CoreState } from 'src/app/core/store/state/core.state';
import { selectUsername } from 'src/app/auth/store/selectors/auth.selector';
import { RegisterStart } from '../../store/actions/admindb.actions';
import { selectRegisterStatus } from '../../store/selectors/admindb.selector';
import { DialogsService } from 'src/app/shared/services/dialogs.service';
import { Collection } from 'src/app/core/model/entities/collection';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit, OnDestroy {

  newuserModel : NewUser = {}
  username : string
  usernamesubscription : Subscription
  userregistersubscription: Subscription
  collectionSelected : Collection = null

  constructor(private store : Store<AdminDashboardState>, private userstore : Store<CoreState>, private dialogService: DialogsService)
  {
    this.usernamesubscription = userstore.select(selectUsername).subscribe((name)=>{this.username = name})
    this.userregistersubscription = store.select(selectRegisterStatus).subscribe((status) => {
      if(status == 1)
        dialogService.showConfirmation("Success", "User registered correctly")
    })
  }

  ngOnInit() {
  }

  ngOnDestroy()
  {
    this.usernamesubscription.unsubscribe()
  }

  startRegister()
  {
    this.newuserModel.adminCreator = this.username
    this.store.dispatch(new RegisterStart(this.newuserModel))
  }

  generateRandomPWD()
  {
    event.preventDefault()
    let randompwd = Math.random().toString(36);
    this.newuserModel.password = randompwd
  }

}
