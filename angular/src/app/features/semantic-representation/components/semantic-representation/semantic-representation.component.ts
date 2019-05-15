import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {GetImageProjection} from '../../../document-analysis/store/actions/document-analysis.actions';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Region} from '../../../../core/model/entities/region';
import {ConvertAgnostic2Semantic} from '../../store/actions/semantic-representation.actions';
import {Notation} from '../../services/notation';
import {selectNotation} from '../../store/selectors/semantic-representation.selector';

@Component({
  selector: 'app-semantic-representation',
  templateUrl: './semantic-representation.component.html',
  styleUrls: ['./semantic-representation.component.css']
})
export class SemanticRepresentationComponent implements OnInit {

  imageID: number;
  notation$: Observable<Notation>;
  selectedRegionZoomFactor = 1;
  selectedRegion: Region;
  isManualEntryCollapsed = true;


  constructor(private route: ActivatedRoute, private router: Router, private store: Store<any>) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
      this.store.dispatch(new GetImageProjection(+this.imageID));

      setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        this.store.dispatch(new ActivateLink({title: 'Semantic', routerLink: 'semanticrepresentation/' + this.imageID}));
      });

    });

    this.notation$ = this.store.select(selectNotation);
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openAgnosticRepresentation() {
    this.router.navigate(['agnosticrepresentation', this.imageID]);
  }

  convertAgnosticSemantic() {
    this.store.dispatch(new ConvertAgnostic2Semantic(this.selectedRegion, true, 'verovio'));
  }

  setSelectedRegion($event: Region) {
    setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
      this.selectedRegion = $event;
    });
  }
}
