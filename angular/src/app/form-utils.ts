import {FormArray, ValidatorFn} from '@angular/forms';
import {Injectable} from '@angular/core';

@Injectable()
export class FormUtils {
  public static minSelectedCheckboxes(min = 1) {
    const validator: ValidatorFn = (formArray: FormArray) => {
      const totalSelected = formArray.controls
        .map(control => control.value)
        .reduce((prev, next) => next ? prev + next : prev, 0);

      return totalSelected >= min ? null : { required: true };
    };

    return validator;
  }
}
