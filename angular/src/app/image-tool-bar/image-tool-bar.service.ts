import {EventEmitter, Injectable} from '@angular/core';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
/**
 * It contains the share data of the toolbar
 */
export class ImageToolBarService {
  private _selectedTool = '101';
  private _selectedToolSubject = new Subject();
  selectedTool$ = this._selectedToolSubject.asObservable();

  clearDocumentAnalysisEvent = new EventEmitter<any>();
  currentActivePanel = 'documentAnalysisMode';

  constructor() { }


  get selectedTool(): string {
    return this._selectedTool;
  }

  set selectedTool(value: string) {
    this._selectedTool = value;
    this._selectedToolSubject.next(value);
  }
}
