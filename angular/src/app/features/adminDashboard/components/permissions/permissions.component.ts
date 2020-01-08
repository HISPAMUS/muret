import { Component, OnInit } from '@angular/core';
import { Store, State } from '@ngrx/store';
import { Subscription, Observable } from 'rxjs';
import { Collection } from 'src/app/core/model/entities/collection';
import { User } from 'src/app/core/model/entities/user';
import { GetUserPermissions } from 'src/app/core/store/actions/user.actions';
import { selectUserPermissions } from 'src/app/core/store/selectors/user.selector';
import { UserState } from 'src/app/core/store/state/user.state';
import { DialogsService } from 'src/app/shared/services/dialogs.service';
import { AdminDashboardState } from '../../store/state/admindb.state';
import { RevokePermissions } from '../../store/actions/admindb.actions';
import { selectRevokedFlag } from '../../store/selectors/admindb.selector';

@Component({
  selector: 'app-permissions',
  templateUrl: './permissions.component.html',
  styleUrls: ['./permissions.component.css']
})
export class PermissionsComponent implements OnInit {

  private userPermissions$ : Observable<any[]>
  private collectionsSubscription: Subscription

  titles : String[] = []
  values: any[] = []

  revokedFlag: Observable<Number>
  grantedFlag: Observable<Number>

  constructor(private store: Store<UserState>, private adminStore : Store<AdminDashboardState>, private dialogs: DialogsService) 
  {
    this.userPermissions$ = this.store.select(selectUserPermissions)
    this.revokedFlag = this.adminStore.select(selectRevokedFlag)
  }

  ngOnInit() 
  {
    this.store.dispatch(new GetUserPermissions())
    this.collectionsSubscription = this.userPermissions$.subscribe((element: any)=>{
      if(element != null)
      {
        console.log(element)
        for(let key in element)
        {
          this.titles.push(key)
          this.values.push(element[key])
        }

        console.log(this.values)
      }
    })

    this.revokedFlag.subscribe((value: number) => 
    {
      if(value)
      {
        this.dialogs.showConfirmarion("Success", "Permissions revoked").subscribe(()=>{
          window.location.reload() 
        })
        
      }
    })


  }

  revokePermissions(user, collection)
  {
    const message = `Are you sure you want to revoke permisions on ${collection} to ${user} ?`
    this.dialogs.showWarningConfirmation("Warning", message).subscribe((isconfirmed)=>{
      if(isconfirmed)
      {
        this.adminStore.dispatch(new RevokePermissions({userName: user, collectionID: collection, typeOfPermission: "W"}))
      }
    })
  }

}
