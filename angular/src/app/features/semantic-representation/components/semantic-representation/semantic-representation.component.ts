  import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {GetImageProjection} from '../../../document-analysis/store/actions/document-analysis.actions';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {Store} from '@ngrx/store';
import {Observable, Subscription} from 'rxjs';
import {Region} from '../../../../core/model/entities/region';
import {
  ClearNotation,
  ConvertAgnostic2Semantic,
  GetNotation,
  SendSemanticEncoding
} from '../../store/actions/semantic-representation.actions';
  import {selectNotation} from '../../store/selectors/semantic-representation.selector';
  import {Notation} from '../../services/notation';

@Component({
  selector: 'app-semantic-representation',
  templateUrl: './semantic-representation.component.html',
  styleUrls: ['./semantic-representation.component.css']
})
export class SemanticRepresentationComponent implements OnInit, OnDestroy {

  imageID: number;
  notationSubscription: Subscription;
  selectedRegionZoomFactor = 1;
  selectedRegion: Region;
  isManualEntryCollapsed = true;
  errorMessage: string = null;
  semanticEncoding = '';
  private semanticEncodingTextAreaContent: string;
  notation: Notation;

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

    this.notationSubscription = this.store.select(selectNotation).subscribe(next => {
      if (next) {
        if (next.errorMessage != null) {
          this.errorMessage = next.errorMessage;
        } else {
          this.errorMessage = null;
          this.semanticEncoding = next.semanticEncoding;
          this.notation = next;
        }
      }
    });
  }

  ngOnDestroy(): void {
    this.notationSubscription.unsubscribe();
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openAgnosticRepresentation() {
    this.router.navigate(['agnosticrepresentation', this.imageID]);
  }

  convertAgnosticSemantic() {
    this.store.dispatch(new ConvertAgnostic2Semantic(this.selectedRegion, false, 'verovio'));
  }

  setSelectedRegion($event: Region) {
    setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
      this.selectedRegion = $event;
      this.errorMessage = null;
      this.notation = null;
      this.semanticEncoding = '';

      if (this.selectedRegion) {
        this.store.dispatch(new GetNotation(this.selectedRegion, false, 'verovio')); // TODO
      } else {
        this.store.dispatch(new ClearNotation());
      }
    });
  }

  manualInputChanged($event: any) {
    this.semanticEncodingTextAreaContent = $event;
    // TODO ¿lo enviamos con intro, en cada tecleo? - combinación de teclas? console.log($event);
  }

  sendSemanticEncoding() {
    this.store.dispatch(new SendSemanticEncoding(this.selectedRegion, this.semanticEncodingTextAreaContent, false, 'verovio')); // TODO
  }
}
