import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Part} from '../../../../core/model/entities/part';
import {Subscription} from 'rxjs';
import {selectPartsServerError} from '../../store/selectors/parts.selector';
import {ResetPartsServerError} from '../../store/actions/parts.actions';
import {Store} from '@ngrx/store';
import {ShowErrorService} from '../../../../core/services/show-error.service';
import {PartsState} from '../../store/state/parts.state';

@Component({
  selector: 'app-part-selection',
  templateUrl: './part-selection.component.html',
  styleUrls: ['./part-selection.component.css']
})
export class PartSelectionComponent implements OnInit, OnDestroy {
  @Input() label: string;
  @Input() parts: Part[];

  @Output() clearPart = new EventEmitter();
  @Output() selectPart: EventEmitter<Part> = new EventEmitter<Part>();
  @Output() createPart: EventEmitter<string> = new EventEmitter<string>();

  private partsServerError: Subscription;

  constructor(private store: Store<PartsState>,
              private showErrorService: ShowErrorService) { }

  ngOnInit() {
    this.partsServerError = this.store.select(selectPartsServerError).subscribe(next => {
      if (next) {
        this.showErrorService.warning(next);
        this.store.dispatch(new ResetPartsServerError());
      }
    });
  }

  ngOnDestroy(): void {
    this.partsServerError.unsubscribe();
  }

  clear() {
    this.clearPart.emit();
  }

  select(part: Part) {
    this.selectPart.emit(part);
  }

  submitAddPart(form: any) {
    this.createPart.emit(form.value.newPartName);
    form.reset();
  }
}
