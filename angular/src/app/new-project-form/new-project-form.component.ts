import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import {RestClientService} from '../services/rest-client.service';
import {Router} from '@angular/router';

// import { ImageCropperModule } from 'ngx-image-cropper';
import {NGXLogger} from 'ngx-logger';
import {ProjectService} from "../services/project.service";
import {SessionDataService} from "../services/session-data.service";

@Component({
  selector: 'app-new-project-form',
  templateUrl: './new-project-form.component.html',
  styleUrls: ['./new-project-form.component.css']
})

export class NewProjectFormComponent implements OnInit {
  imgSrc: string;

  newProjectForm = this.fb.group({
    name: ['', Validators.required],
    composer: [''],
    notationType: ['eMensural', Validators.required],
    manuscriptType: ['eHandwritten', Validators.required],
    comments: ['']
  });

  constructor(private fb: FormBuilder, private sessionDataService: SessionDataService, private projectService: ProjectService, private router: Router, private logger: NGXLogger) {
  }

  ngOnInit() {
  }

  onReset() {
  }

  onSelect($event: any) {
    this.imgSrc = $event;
  }

  onSubmit() {
    this.logger.debug('Submitting new project');
    this.projectService.newProject$(this.newProjectForm.controls['name'].value,
      this.newProjectForm.controls['composer'].value,
      this.newProjectForm.controls['notationType'].value,
      this.newProjectForm.controls['manuscriptType'].value,
      this.newProjectForm.controls['comments'].value, this.imgSrc)
      .subscribe(serviceNewProject => {
          this.sessionDataService.user.projectsCreated.push(serviceNewProject);
          this.router.navigate(['/project/get', {id: serviceNewProject.id}])
        }
      );
    // TODO ¿Si hay error?
  }

}
