import {Component, ElementRef, OnInit, QueryList, Renderer2, Self, ViewChild, ViewChildren} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ProjectService} from '../../project.service';
import {Image} from '../../../../shared/entities/image';
import {Observable} from 'rxjs';
import {Project} from '../../../../shared/entities/project';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],
  providers: [ProjectService] // because it is not a singleton
})
export class ProjectComponent implements OnInit {
  project$: Observable<Project>;
  images$: Observable<Image[]>;

  constructor(@Self() private projectService: ProjectService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.project$ = this.projectService.getProject$(id);
    this.images$ = this.projectService.getProjectImages$(id);
  }

  trackByImageFn(index, item: Image) {
    return item.id; // unique id corresponding to the item
  }
}
