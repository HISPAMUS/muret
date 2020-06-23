import {Component, isDevMode, OnInit, OnChanges, OnDestroy, Input} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {CoreState} from '../../../core/store/state/core.state';
import {Store} from '@ngrx/store';
import {selectIsAuthenticated, selectUsername, selectRole} from '../../../auth/store/selectors/auth.selector';
import {selectServerStatus } from 'src/app/core/store/selectors/core.selector';
import { GetServerStatus } from 'src/app/core/store/actions/serverStatus.actions';
import { DialogsService} from 'src/app/shared/services/dialogs.service';
import { ModalOptions } from 'src/app/shared/components/options-dialog/options-dialog.component';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit, OnDestroy {
  isDev = isDevMode();

  menuVisible = true;
  isAuthenticated$: Observable<boolean>;
  username$: Observable<string>;
  userRoles$: Observable<string[]>;
  serverStatus$: Observable<string>;

  @Input() indicator : string = "";

  serverStatusSubscription : Subscription;
  adminStatusSubscription: Subscription;

  isAdmin: boolean;

  interval : number;

  userWarned: boolean;

  constructor(private store: Store<CoreState>, private dialogservice : DialogsService) {
    this.isAuthenticated$ = this.store.select(selectIsAuthenticated);
    this.username$ = this.store.select(selectUsername);
    this.serverStatus$ = this.store.select(selectServerStatus);
    this.userRoles$ = this.store.select(selectRole);
    this.isAdmin = false;

    this.serverStatusSubscription = this.serverStatus$.subscribe((status: string) =>{
      if(status === 'OFF')
      {
        this.indicator = "error";
        if(!this.userWarned)
        {
          dialogservice.showError('This is embarrassing...', 'Classification server is down, you will not be able to perform your work. Technicians have been warned, however if it is urgent you can contact them at arios@dlsi.ua.es or drizo@dlsi.ua.es');
          this.userWarned = true;
        }
      }
    })

    this.adminStatusSubscription = this.userRoles$.subscribe((roles: any) => {

      if(roles!= null && roles.length>0)
      {
        for(let object of roles)
        {
          this.isAdmin = (object.authority == 'ADMIN')
        }
      }
    })

  }

  ngOnInit()
  {
    this.store.dispatch(new GetServerStatus())
    this.interval = setInterval(()=>{
      this.store.dispatch(new GetServerStatus())
    }, 30 * 1000);
  }

  ngOnDestroy()
  {
    this.serverStatusSubscription.unsubscribe();
  }
}
