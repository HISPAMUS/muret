import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {DocumentState} from '../../store/state/document.state';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {selectDocument, selectDocumentAPIRestErrorSelector} from '../../store/selectors/document.selector';
import {DocumentGetDocument, DocumentResetServerError} from '../../store/actions/document.actions';
import {Observable, Subscription} from 'rxjs';
import {Document} from '../../../../core/model/entities/document';
import {PartUsedIn, UsesOfAllParts} from '../../../../core/model/restapi/uses-of-all-parts';
import {NumberPair} from '../../../../core/model/restapi/number-pair';
import {Part} from '../../../../core/model/entities/part';
import {CreatePart, DeletePart, GetUsesOfParts, RenamePart} from '../../../parts/store/actions/parts.actions';
import {selectUsesOfParts} from '../../../parts/store/selectors/parts.selector';
import {ShowErrorService} from '../../../../core/services/show-error.service';

@Component({
  selector: 'app-instruments',
  templateUrl: './instruments.component.html',
  styleUrls: ['./instruments.component.css']
})
export class InstrumentsComponent implements OnInit, OnDestroy {
  document$: Observable<Document>;
  usesOfParts$: Observable<UsesOfAllParts>;
  private documentID: number;
  private serverErrorSubscription: Subscription;

  constructor(private route: ActivatedRoute, private store: Store<DocumentState>, private router: Router,
              private dialogsService: DialogsService, private showErrorService: ShowErrorService) {
    this.document$ = this.store.select(selectDocument);
    this.usesOfParts$ = this.store.select(selectUsesOfParts);
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.documentID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      // this.store.dispatch(new DocumentGetDocument(this.documentID));
      // The use of parts and document should already be loaded at document component
      // this.store.dispatch(new GetUsesOfParts(this.documentID));
    });
    this.serverErrorSubscription = this.store.select(selectDocumentAPIRestErrorSelector).subscribe(next => {
      if (next) {
        this.showErrorService.showServerError(next);
        this.store.dispatch(new DocumentResetServerError());
      }
    });
  }

  ngOnDestroy(): void {
    this.serverErrorSubscription.unsubscribe();
  }

  trackByPartFn(index, item: PartUsedIn) {
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
    this.router.navigate(['semanticrepresentation', region.x, {region_id: region.y}]);
  }

  openSymbol(symbol: NumberPair) {
    // TODO
  }

  isDeleteDisabled(partUses: PartUsedIn): boolean {
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
      this.store.dispatch(new CreatePart(this.documentID, newValue));
    });
  }
}
