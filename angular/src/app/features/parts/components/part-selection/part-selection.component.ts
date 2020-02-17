import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Part} from '../../../../core/model/entities/part';
import {Observable, Subscription} from 'rxjs';

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

  private serverErrorSubscription: Subscription;

  constructor() { }

  ngOnInit() {
  }

  ngOnDestroy(): void {
    this.serverErrorSubscription.unsubscribe();
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
