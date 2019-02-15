import {Component, Input, ViewChild, forwardRef, Output, EventEmitter} from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from '@angular/forms';

const VALUE_ACCESSOR = {
  provide: NG_VALUE_ACCESSOR,
  useExisting: forwardRef(() => InlineEditComponent),
  multi: true
};

@Component({
  selector: 'app-inline-edit',
  templateUrl: './inline-edit.component.html',
  providers: [VALUE_ACCESSOR],
  styleUrls: ['./inline-edit.component.scss']
})

export class InlineEditComponent implements ControlValueAccessor {
  @Input() size = '80';
  @Input() label = 'Enter value here';
  @Input() required = true;
  @Output() changed = new EventEmitter();
  private _value: string;
  private preValue = '';
  private editing = false;
  public onChange: any = Function.prototype;
  public onTouched: any = Function.prototype;

  get value(): any {
    if (this._value === null || this._value === '') {
      return this.label;
    } else {
      return this._value;
    }
  }

  set value(v: any) {
    if (v !== this._value) {
      this._value = v;
    }
  }

  writeValue(value: any) {
    this._value = value;
  }

  public registerOnChange(fn: (_: any) => {}): void {
    this.onChange = fn;
  }

  public registerOnTouched(fn: () => {}): void {
    this.onTouched = fn;
  }

  onBlur($event: Event) {
    this.editing = false;
    if ( this._value === '') {
      this._value = 'No value available';
    }
    this.changed.emit(this._value);
  }

  beginEdit(value) {
    this.preValue = value;
    this.editing = true;
  }
}
