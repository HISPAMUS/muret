import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import {Im3wsService} from '../services/im3ws.service';
import {Router} from '@angular/router';

// import { ImageCropperModule } from 'ngx-image-cropper';
import {NGXLogger} from 'ngx-logger';

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

  constructor(private fb: FormBuilder, private projectService: Im3wsService, private router: Router, private logger: NGXLogger) {
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
    this.projectService.projectService.newProject$(this.newProjectForm.controls['name'].value,
      this.newProjectForm.controls['composer'].value,
      this.newProjectForm.controls['notationType'].value,
      this.newProjectForm.controls['manuscriptType'].value,
      this.newProjectForm.controls['comments'].value, this.imgSrc)
      .subscribe(serviceNewProject =>
        this.router.navigate(['/project/get', { id: serviceNewProject.id }])
      );
    // TODO ¿Si hay error?
  }

}
