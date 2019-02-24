import {Component, OnDestroy, OnInit} from '@angular/core';
import saveAs from 'file-saver';
import {TrainingSetExporter} from '../../../../shared/entities/training-set-exporter';
import {Project} from '../../../../shared/entities/project';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {FormUtils} from '../../../../shared/utils/form-utils';
import {ExporterService} from '../../exporter.service';
import {TrainingSetExporterService} from '../../training-set-exporter.service';


@Component({
  selector: 'app-training-sets',
  templateUrl: './training-sets.component.html',
  styleUrls: ['./training-sets.component.css'],
  providers: [ExporterService, TrainingSetExporterService]
})
export class TrainingSetsComponent implements OnInit {
  projects: Project[];
  exporters: TrainingSetExporter[];
  form: FormGroup;
  selectedExporterId: number;
  currentCursor = 'default';

  constructor(private exporterService: ExporterService,
              private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      exportersFormArray: new FormArray([], Validators.required),
      projectsFormArray: new FormArray([], FormUtils.minSelectedCheckboxes(1))
    });
  }

  ngOnInit() {
    this.exporterService.getTrainingSetExporters().subscribe(value => {
      this.exporters = value;
      const controls = this.exporters.map(c => new FormControl(false));
      controls.forEach(c => {
        (this.form.get('exportersFormArray') as FormArray).push(c);
      });
      this.onExporterSelected(controls.length - 1); // TODO Parche
    });

    this.exporterService.getUserAuthorizedProjects().subscribe(value => {
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
    this.exporterService.downloadTrainingSet$(this.selectedExporterId, selectedProjectIDS).subscribe(data => {
      const blob1 = new Blob([data], { type: 'application/x-gzip' });
      saveAs.saveAs(blob1, 'training_set.tgz'); // TODO file name
      this.currentCursor = 'default';
    });
  }

  onExporterSelected(i: number) {
    this.selectedExporterId = this.exporters[i].id;
  }
}
