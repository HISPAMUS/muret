import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {ProjectState} from '../../store/state/project.state';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {selectProject} from '../../store/selectors/project.selector';
import {GetProject} from '../../store/actions/project.actions';
import {Observable} from 'rxjs';
import {Project} from '../../../../core/model/entities/project';
import {PartUses, UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';
import {NumberPair} from '../../../../core/model/restapi/number-pair';
import {Part} from '../../../../core/model/entities/part';
import {CreatePart, DeletePart, GetUsesOfParts, RenamePart} from '../../../parts/store/actions/parts.actions';
import {selectUsesOfParts} from '../../../parts/store/selectors/parts.selector';

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
      // this.store.dispatch(new GetProject(this.projectID)); // The use of parts and project should already be loaded at project component
      // this.store.dispatch(new GetUsesOfParts(this.projectID));
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

  isDeleteDisabled(partUses: PartUses): boolean {
    return partUses.symbols != null && partUses.symbols.length > 0 ||
      partUses.regions != null && partUses.regions.length > 0 ||
      partUses.pages != null && partUses.pages.length > 0 ||
      partUses.images != null && partUses.images.length > 0;
  }

  renamePart(part: Part) {
    this.dialogsService.showInput('Rename part / instrument', 'Set new name for part', part.name).subscribe(newValue => {
      if (newValue) {
        this.store.dispatch(new RenamePart(part, newValue));
      }
    });
  }

  deletePart(part: Part) {
    this.dialogsService.showWarningConfirmation('Delete part?', 'You are about to delete the part ' + part.name)
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.store.dispatch(new DeletePart(part.id));
        }
      });
  }

  addPart() {
    this.dialogsService.showInput('Add part / instrument', '', '').subscribe(newValue => {
      this.store.dispatch(new CreatePart(this.projectID, newValue));
    });
  }
}
