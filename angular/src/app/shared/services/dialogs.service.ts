import { Injectable } from '@angular/core';
import {ConfirmDialogComponent} from '../components/confirm-dialog/confirm-dialog.component';
import {Clear} from '../../features/document-analysis/store/actions/document-analysis.actions';
import {SimpleModalService} from 'ngx-simple-modal';
import {Observable, of} from 'rxjs';
import {AlertComponent} from '../components/error-modal-message/alert.component';
import {InputDialogComponent} from '../components/input-dialog/input-dialog.component';
import { ConfirmDialogWarningComponent } from '../components/confirm-dialog-warning/confirm-dialog-warning.component';

@Injectable({
  providedIn: 'root'
})
export class DialogsService {

  constructor(private simpleModalService: SimpleModalService) { }

  public showConfirmarion(title: string, message: string): Observable<boolean> {
    return this.simpleModalService.addModal(ConfirmDialogComponent, {
      title,
      message
    });
  }

  public showWarningConfirmation(title: string, message: string): Observable<boolean>{
    return this.simpleModalService.addModal(ConfirmDialogWarningComponent, {
      title, message
    });
  }

  public showError(title: string, specificMessage: string, errmessage?: string) {
    
    let message: string

    if(errmessage === "")
       message = "There was an error during the request to the classification server"
    else
       message = errmessage
    
      return this.simpleModalService.addModal(AlertComponent, {
      title,
      message,
      specificMessage
    });
  }

  public showInput(title: string, currentValue: string): Observable<string> {
    return this.simpleModalService.addModal(InputDialogComponent, {
      title,
      currentValue
    });
  }

}
