import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import {Field} from '../../model/field.interface';

@Component({
    selector: 'app-checkbox',
    templateUrl: './checkbox.component.html',
    styleUrls: ['./checkbox.component.css']
})
export class CheckboxComponent implements OnInit {
    field: Field;
    group: FormGroup;

    constructor() { }

    ngOnInit() {
    }

}
