import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Part} from '../../../../core/model/entities/part';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-part-selection',
  templateUrl: './part-selection.component.html',
  styleUrls: ['./part-selection.component.css']
})
export class PartSelectionComponent implements OnInit {
  @Input() label: string;
  @Input() parts: Part[];

  @Output() clearPart = new EventEmitter();
  @Output() selectPart: EventEmitter<Part> = new EventEmitter<Part>();
  @Output() createPart: EventEmitter<string> = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
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