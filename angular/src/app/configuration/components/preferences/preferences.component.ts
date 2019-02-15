import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {RestClientService} from '../../../services/rest-client.service';
import {ClassifierType} from '../../../model/classifier-type';
import {Classifier} from '../../../model/classifier';
import {ClassifierCrudService} from "../../../services/crud/classifier-crud.service";

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.css']
})
export class PreferencesComponent implements OnInit {

  constructor(private classifierService: ClassifierCrudService) {
  }

  classifierTypes: ClassifierType[];
  preferencesGroup = new FormGroup({
    symbolImageClassifiersSelect: new FormControl()
  });
  onSubmit() {
  }

  ngOnInit(): void {
    this.classifierService.getClassifierTypes$().subscribe(next => {
      this.classifierTypes = next;
    });
  }

  trackByClassifierFunction(index, item: Classifier) {
    return item.id; // unique id corresponding to the item
  }

  trackByClassifierTypeFunction(index, item: ClassifierType) {
    return item.id; // unique id corresponding to the item
  }
}
