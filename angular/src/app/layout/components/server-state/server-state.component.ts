import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {selectCoreServerStatus} from "../../../core/store/selectors/core.selector";
import {Store} from "@ngrx/store";
import {CoreState} from "../../../core/store/state/core.state";
import {CoreGetServerStatus} from "../../../core/store/actions/server-status.actions";
import {DialogsService} from "../../../shared/services/dialogs.service";
import {NgbTooltipConfig} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-server-state',
  templateUrl: './server-state.component.html',
  styleUrls: ['./server-state.component.css']
})
export class ServerStateComponent implements OnInit, OnDestroy {
  serverStatus$: Observable<string>;
  serverStatusSubscription : Subscription;
  interval : number;

  userWarned: boolean;
  serverError: boolean;
  // TODO Message with information of what happens - tooltip is not working !!
  serverErrorMessage = 'Classification server is down, you will not be able to perform your work. Technicians have been warned, however if it is urgent you can contact them at arios@dlsi.ua.es or drizo@dlsi.ua.es';

  constructor(private store: Store<CoreState>, private dialogService : DialogsService, tooltipConfig: NgbTooltipConfig) {
    // customize default values of tooltips used by this component tree
    tooltipConfig.placement = 'bottom';
    tooltipConfig.triggers = 'focus';
  }

  ngOnInit(): void {
    this.serverStatus$ = this.store.select(selectCoreServerStatus);
    this.serverStatusSubscription = this.serverStatus$.subscribe((status: string) =>{
      if(status === 'OFF') {
        this.serverError = true;
        if( !this.userWarned) {
          this.dialogService.showError('This is embarrassing...', this.serverErrorMessage);
          this.userWarned = true;
        }
      } else {
        this.serverError = false;
      }
    });

    this.store.dispatch(new CoreGetServerStatus())
    this.interval = setInterval(()=>{
      this.store.dispatch(new CoreGetServerStatus())
    }, 30 * 1000);

  }

  ngOnDestroy(): void {
    this.serverStatusSubscription.unsubscribe();
  }

}
