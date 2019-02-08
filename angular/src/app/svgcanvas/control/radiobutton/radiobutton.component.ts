import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import {Field} from '../../model/field.interface';

@Component({
    selector: 'app-radiobutton',
    templateUrl: './radiobutton.component.html',
    styleUrls: ['./radiobutton.component.css']
})
export class RadiobuttonComponent implements OnInit {
    field: Field;
    group: FormGroup;

    constructor() { }

    ngOnInit() {
    }

}
