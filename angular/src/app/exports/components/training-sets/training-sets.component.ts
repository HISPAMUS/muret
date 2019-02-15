import { Component, OnInit } from '@angular/core';
import saveAs from 'file-saver';
import {Project} from '../../../model/project';
import {SessionDataService} from '../../../services/session-data.service';
import {ITrainingSetExporter} from '../../../model/itraining-set-exporter';
import {FormArray, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators} from '@angular/forms';
import {FormUtils} from '../../../form-utils/form-utils';
import {TrainingSetCrudService} from "../../../services/crud/training-set-crud.service";
import {ProjectCrudService} from "../../../services/crud/project-crud.service";

@Component({
  selector: 'app-training-sets',
  templateUrl: './training-sets.component.html',
  styleUrls: ['./training-sets.component.css']
})
export class TrainingSetsComponent implements OnInit {
  exporters: Array<ITrainingSetExporter>;
  projects: Array<Project>;
  form: FormGroup;
  selectedExporterId: number;
  currentCursor = 'default';

  constructor(private projectService: ProjectCrudService, private trainingSetService: TrainingSetCrudService, private sessionDataService: SessionDataService, private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      exportersFormArray: new FormArray([], Validators.required),
      projectsFormArray: new FormArray([], FormUtils.minSelectedCheckboxes(1))
    });
  }

  ngOnInit() {
    this.trainingSetService.getTrainingSetExporters$().pipe().subscribe(value => {
      this.exporters = value;
      const controls = this.exporters.map(c => new FormControl(false));
      controls.forEach(c => {
        (this.form.get('exportersFormArray') as FormArray).push(c);
      });
      this.onExporterSelected(controls.length - 1); // TODO Parche
    });
    this.projectService.getProjects$().subscribe(value => {
      this.projects = value;

      const controls = this.projects.map(c => new FormControl(false));
      const projectsFormArray = (this.form.get('projectsFormArray') as FormArray);
      controls.forEach(c => {
        projectsFormArray.push(c);
      });
     });
  }

  submit() {
    const selectedProjectIDS = Array<number>();
    let index = 0;
    (this.form.get('projectsFormArray') as FormArray).controls.forEach(cb => {
      if (cb.value) {
        selectedProjectIDS.push(this.projects[index].id);
      }
      index++;
    });

    this.currentCursor = 'wait';
    this.trainingSetService.downloadTrainingSet$(this.selectedExporterId, selectedProjectIDS).subscribe(data => {
      const blob1 = new Blob([data], { type: 'application/x-gzip' });
      saveAs.saveAs(blob1, 'training_set.tgz'); // TODO file name
      this.currentCursor = 'default';
    });
  }

  onExporterSelected(i: number) {
    this.selectedExporterId = this.exporters[i].id;
  }
}
