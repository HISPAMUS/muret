import { Actions, ofType, Effect } from '@ngrx/effects';
import { Injectable } from '@angular/core';
import { CoreGetServerStatus, serverStatusActionTypes, GetStatusSuccess } from '../actions/server-status.actions';
import { ServerStatusService } from '../../services/server-status.service';
import { switchMap, map } from 'rxjs/operators';
import { StringResponse } from '../../model/restapi/string-response';

@Injectable()
export class ServerStatusEffects
{
    constructor(private actions$: Actions, private statusService: ServerStatusService)
    {

    }

    @Effect()
    getServerStatus$ = this.actions$.pipe(
        ofType<CoreGetServerStatus>(serverStatusActionTypes.GetStatus),
        switchMap(()=>{
            return this.statusService.getServerStatus$().pipe(
                map((response: StringResponse)=>{
                    return new GetStatusSuccess(response.response)
                })
            )
        }
    )
    )
}
