import {Component, OnDestroy, OnInit} from '@angular/core';
import saveAs from 'file-saver';
import {TrainingSetExporter} from '../../../../core/model/entities/training-set-exporter';
import {Project} from '../../../../core/model/entities/project';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {FormUtils} from '../../../../shared/utils/form-utils';
import {ExporterService} from '../../services/exporter.service';
import {Store} from '@ngrx/store';
import {Subscription} from 'rxjs';
import {GetTrainingSetExporters} from '../../store/actions/export.actions';
import {GetUser} from '../../../../core/store/actions/user.actions';
import {selectAuthState} from '../../../../auth/store/selectors/auth.selector';
import {selectLoggedInUser} from '../../../../core/store/selectors/user.selector';
import {selectTrainingSetExporters} from '../../store/selectors/training-set-exporters.selector';
import {flatten} from '@angular/compiler';


@Component({
  selector: 'app-training-sets',
  templateUrl: './training-sets.component.html',
  styleUrls: ['./training-sets.component.css']
})
export class TrainingSetsComponent implements OnInit, OnDestroy {
  private authSubscription: Subscription;

  form: FormGroup;
  selectedExporterId: number;
  currentCursor = 'default';
  private exportersSubscription: Subscription;
  private userSubscription: Subscription;

  projects: Project[];
  exporters: TrainingSetExporter[];
  exporting: boolean;

  constructor(private store: Store<any>,
              private formBuilder: FormBuilder,
              private exporterService: ExporterService
              ) {
    this.form = this.formBuilder.group({
      exportersFormArray: new FormArray([], Validators.required),
      projectsFormArray: new FormArray([], FormUtils.minSelectedCheckboxes(1))
    });
  }

  ngOnInit() {
    this.authSubscription = this.store.select(selectAuthState).subscribe(next => {
      this.store.dispatch(new GetUser(next.userID));
    });

    this.store.dispatch(new GetTrainingSetExporters());


    this.exportersSubscription = this.store.select(selectTrainingSetExporters).subscribe(next => {
        const exportersFormArray = (this.form.get('exportersFormArray') as FormArray);
        if (next && exportersFormArray.length === 0) {
          this.exporters = next;
          const controls = this.exporters.map(c => new FormControl(false));
          controls.forEach(c => {
            exportersFormArray.push(c);
          });
          this.onExporterSelected(controls.length - 1);
        }
      }
    );

    this.userSubscription = this.store.select(selectLoggedInUser).subscribe(next => {
      const projectsFormArray = (this.form.get('projectsFormArray') as FormArray);
      if (next && projectsFormArray.controls.length === 0) {
        if (next && next.permissions) {
          this.projects = flatten([...next.permissions.map((permission) => permission.collection.projects)]);
          const controls = this.projects.map(c => new FormControl(false));
          controls.forEach(c => {
            projectsFormArray.push(c);
          });
        }
        // this.projects = flatten([...next.projectsCreated, ...next.permissions.map((permission) => permission.collection.projects)]);
      }
    });
  }


  onExporterSelected(i: number) {
    this.selectedExporterId = this.exporters[i].id;
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

    // we better perform it using directly the service rather than using redux because we don't want to save the blob state
    this.currentCursor = 'wait';
    this.exporting = true;
    this.exporterService.downloadTrainingSet$(this.selectedExporterId, selectedProjectIDS).subscribe(data => {
      const blob1 = new Blob([data], { type: 'application/x-gzip' });
      this.exporting = false;
      saveAs.saveAs(blob1, 'training_set.tgz'); // TODO file name
      this.currentCursor = 'default';
    });
  }


  ngOnDestroy(): void {
    this.authSubscription.unsubscribe();
    this.userSubscription.unsubscribe();
    this.exportersSubscription.unsubscribe();
  }

  getButtonLabel() {
    if (this.exporting) {
      return 'Exporting... (it can take several minutes)';
    } else {
      return 'Export training set';
    }
  }

  doesNotHavePermission(trainingSetExporter: TrainingSetExporter) {
    if (trainingSetExporter.adminPermissionRequired) {
      return false; // true; // TODO - depende de usuario
    }
    return false;
  }
}
