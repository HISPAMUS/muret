import { Component, OnInit, OnDestroy } from '@angular/core';
import { Store, State } from '@ngrx/store';
import { Subscription, Observable } from 'rxjs';
import { Collection } from 'src/app/core/model/entities/collection';
import { User } from 'src/app/core/model/entities/user';
import { GetUserPermissions, GetUsers } from 'src/app/core/store/actions/user.actions';
import { selectUserPermissions, selectUserList } from 'src/app/core/store/selectors/user.selector';
import { UserState } from 'src/app/core/store/state/user.state';
import { DialogsService } from 'src/app/shared/services/dialogs.service';
import { AdminDashboardState } from '../../store/state/admindb.state';
import { RevokePermissions, GrantPermissions } from '../../store/actions/admindb.actions';
import { selectRevokedFlag, selectGrantedFlag } from '../../store/selectors/admindb.selector';
import { ModalOptions } from 'src/app/shared/components/options-dialog/options-dialog.component';

@Component({
  selector: 'app-permissions',
  templateUrl: './permissions.component.html',
  styleUrls: ['./permissions.component.css']
})
export class PermissionsComponent implements OnInit, OnDestroy {

  private userPermissions$ : Observable<any[]>
  private collectionsSubscription: Subscription

  titles : String[] = []
  values: any[] = []

  userList: String[] = []

  revokedFlag: Subscription
  grantedFlag: Subscription
  userListSubs: Subscription

  constructor(private store: Store<UserState>, private adminStore : Store<AdminDashboardState>, private dialogs: DialogsService) 
  {
    this.userPermissions$ = this.store.select(selectUserPermissions)
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

    this.revokedFlag = this.adminStore.select(selectRevokedFlag).subscribe((value: number) => 
    {
      if(value)
      {
        this.dialogs.showConfirmarion("Success", "Permissions revoked").subscribe(()=>{
          window.location.reload() 
        }) 
      }
    })

    this.grantedFlag = this.adminStore.select(selectGrantedFlag).subscribe((value: number)=>{
      if(value)
      {
        this.dialogs.showConfirmarion("Success", "Permissions granted").subscribe(()=>{
          window.location.reload() 
        }) 
      }
    })

    this.store.dispatch(new GetUsers())

    this.userListSubs = this.store.select(selectUserList).subscribe((element: string[]) => {
      this.userList = element
    })

  }

  ngOnDestroy()
  {
    this.grantedFlag.unsubscribe()
    this.revokedFlag.unsubscribe()
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

  grantPermissions(id, collection)
  { 
    let namesToGrant = []
    let flag = 0 

    console.log(this.userList)
    const modalOptions: ModalOptions[] = []
    let index = 0
    for(let element of this.userList)
    {
      for (let nameToAvoid of this.values[id])
      {
        if(nameToAvoid == element)
          flag = 1
      }

      if(!flag)
      {
        modalOptions.push({id:index.toString(), name:String(element)})
      }

      flag = 0
      index++    
    }

    this.dialogs.showOptions("Grant permission", modalOptions, "Select user to grant permissions").subscribe((user)=>{
      this.adminStore.dispatch(new GrantPermissions({userName: user.name, collectionID: collection, typeOfPermission: "W"}))
    })
  }

}
