import { Injectable } from '@angular/core';
import {ConfirmDialogComponent} from '../components/confirm-dialog/confirm-dialog.component';
import {SimpleModalService} from 'ngx-simple-modal';
import {Observable, of} from 'rxjs';
import {AlertComponent} from '../components/error-modal-message/alert.component';
import {InputDialogComponent} from '../components/input-dialog/input-dialog.component';
import { ConfirmDialogWarningComponent } from '../components/confirm-dialog-warning/confirm-dialog-warning.component';
import { OptionsDialogComponent, ModalOptions } from '../components/options-dialog/options-dialog.component';
import {LinksModalDialogComponent, onLinkClickType} from '../components/links-modal-dialog/links-modal-dialog.component';


@Injectable({
  providedIn: 'root'
})
export class DialogsService {

  private optionsInDialog;

  constructor(private simpleModalService: SimpleModalService) { }

  public showConfirmation(title: string, message: string): Observable<boolean> {
    return this.simpleModalService.addModal(ConfirmDialogComponent, {
      title,
      message
    });
  }

  public showMessage(title: string, message: string) {
    return this.simpleModalService.addModal(AlertComponent, {
      title,
      message
    });
  }

  public showWarningConfirmation(title: string, message: string): Observable<boolean> {
    return this.simpleModalService.addModal(ConfirmDialogWarningComponent, {
      title, message
    });
  }

  public showError(title: string, specificMessage: string, errmessage?: string) {

    let message: string;

    if (errmessage === '') {
      message = 'There was an error during the request to the classification server';
    } else {
      message = errmessage;
    }
    return this.simpleModalService.addModal(AlertComponent, {
      title,
      message,
      specificMessage
    });
  }

  public showInput(title: string, message: string, currentValue: string): Observable<string> {
    return this.simpleModalService.addModal(InputDialogComponent, {
      title,
      message,
      currentValue
    });
  }

  public showOptions(title: string, options: ModalOptions[], newValueMessage: string): Observable<ModalOptions> {
    const ids: string[] = [];
    const names: string[] = [];

    options.forEach((option: ModalOptions) => {
      ids.push(option.id);
      names.push(option.name);
    });

    return this.simpleModalService.addModal(OptionsDialogComponent, {
      title, ids, names, newValueMessage
    });
  }

  public getOptions() {
    return this.optionsInDialog;
  }

  /**
   * @param links key = url, value = text
   */
  public showLinks(title: string, message: string, links: Map<string, string>, onClickLinks: Map<string, onLinkClickType>) {
    return this.simpleModalService.addModal(LinksModalDialogComponent, {
      title,
      message,
      links,
      onClickLinks
    });
  }
}
