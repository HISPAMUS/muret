import { Injectable } from '@angular/core';
import {ConfirmDialogComponent} from '../components/confirm-dialog/confirm-dialog.component';
import {Clear} from '../../features/document-analysis/store/actions/document-analysis.actions';
import {SimpleModalService} from 'ngx-simple-modal';
import {Observable, of} from 'rxjs';
import {AlertComponent} from '../components/error-modal-message/alert.component';
import {InputDialogComponent} from '../components/input-dialog/input-dialog.component';

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

  public showError(title: string, message: string) {
    return this.simpleModalService.addModal(AlertComponent, {
      title,
      message
    });
  }

  public showInput(title: string, currentValue: string): Observable<string> {
    return this.simpleModalService.addModal(InputDialogComponent, {
      title,
      currentValue
    });
  }

}
