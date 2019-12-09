import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {ProjectState} from '../../store/state/project.state';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {selectProject, selectUsesOfParts} from '../../store/selectors/project.selector';
import {GetProject, GetUsesOfParts} from '../../store/actions/project.actions';
import {Observable} from 'rxjs';
import {Project} from '../../../../core/model/entities/project';
import {PartUses, UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';
import {KeyValue} from '@angular/common';
import {NumberPair} from '../../../../core/model/restapi/number-pair';

@Component({
  selector: 'app-instruments',
  templateUrl: './instruments.component.html',
  styleUrls: ['./instruments.component.css']
})
export class InstrumentsComponent implements OnInit {
  project$: Observable<Project>;
  usesOfParts$: Observable<UsesOfParts>;
  private projectID: number;

  constructor(private route: ActivatedRoute, private store: Store<ProjectState>, private router: Router,
              private dialogsService: DialogsService) {
    this.project$ = this.store.select(selectProject);
    this.usesOfParts$ = this.store.select(selectUsesOfParts);
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.projectID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new GetProject(this.projectID));
      this.store.dispatch(new GetUsesOfParts(this.projectID));
    });
  }

  trackByPartFn(index, item: PartUses) {
    return item.part.id; // unique id corresponding to the item
  }
  trackByNumberFn(index, item: number) {
    return item; // unique id corresponding to the item
  }

  // TODO Servicio apertura imágenes, páginas... para el buscador
  openImage(image: number) {
    this.router.navigate(['semanticrepresentation', image]);
  }

  openPage(page: NumberPair) {
    this.router.navigate(['semanticrepresentation', page.x]);
  }

  openRegion(region: NumberPair) {
    this.router.navigate(['semanticrepresentation/region', {id: region.x, region_id: region.y}]);
  }

  openSymbol(symbol: NumberPair) {
    // TODO
  }

  isDeleteDisabled(partUses: PartUses) {
    return partUses.symbols.length > 0 || partUses.images.length > 0 || partUses.pages.length > 0 || partUses.images.length > 0;
  }
}
