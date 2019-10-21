import {Component, isDevMode, OnInit, OnChanges, OnDestroy} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {CoreState} from '../../../core/store/state/core.state';
import {Store} from '@ngrx/store';
import {selectIsAuthenticated, selectUsername} from '../../../auth/store/selectors/auth.selector';
import {selectServerStatus } from 'src/app/core/store/selectors/user.selector';
import { GetServerStatus } from 'src/app/core/store/actions/serverStatus.actions';
import { DialogsService } from 'src/app/shared/services/dialogs.service';

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
  serverStatus$: Observable<string>;

  serverStatusSubscription : Subscription;


  interval : number;

  userWarned: boolean;

  constructor(private store: Store<CoreState>, private dialogservice : DialogsService) {
    this.isAuthenticated$ = this.store.select(selectIsAuthenticated);
    this.username$ = this.store.select(selectUsername);
    this.serverStatus$ = this.store.select(selectServerStatus);

    this.serverStatusSubscription = this.serverStatus$.subscribe((status: string) =>{
      if(status === "OFF")
      {
        if(!this.userWarned)
        {
          dialogservice.showError("This is embarrassing...", "Classification server is down, you will not be able to perform your work. Technicians have been warned, however if it is urgent you can contact them at (un correito por aquí)");
          this.userWarned = true;
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

  }


}
