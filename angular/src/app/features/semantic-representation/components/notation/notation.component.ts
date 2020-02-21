import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';
import {NotationService} from '../../services/notation.service';
import {Notation} from '../../services/notation';
import {selectSemanticRepresentationServerError} from '../../store/selectors/semantic-representation.selector';
import {ResetSemanticRepresentationServerError} from '../../store/actions/semantic-representation.actions';
import {Store} from '@ngrx/store';
import {Subscription} from 'rxjs';
import {ShowErrorService} from '../../../../core/services/show-error.service';

// Verovio integration based on the code in https://github.com/deanmalone/PianoPlay
@Component({
  selector: 'app-notation',
  templateUrl: './notation.component.html',
  styleUrls: ['./notation.component.css']
})
export class NotationComponent implements OnInit, OnChanges, OnDestroy {
  @Input() notation: Notation;
  notationAsSVG: any;
  private serverErrorSubscription: Subscription;

  constructor(private notationService: NotationService, private store: Store<any>, private showErrorService: ShowErrorService) { }

  ngOnInit() {
    this.serverErrorSubscription = this.store.select(selectSemanticRepresentationServerError).subscribe(next => {
      if (next) {
        this.showErrorService.warning(next);
        this.store.dispatch(new ResetSemanticRepresentationServerError());
      }
    });
  }

  ngOnDestroy(): void {
    this.serverErrorSubscription.unsubscribe();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.notation) {
      // TODO ¿se llama dos veces?
      if (this.notation.notationResponseType === 'mei') {
        this.notationAsSVG = this.notationService.renderStaff(this.notation.content);
      } else if (this.notation.notationResponseType === 'svg') {
        this.notationAsSVG = this.notation.content;
      } else {
        throw new Error('Unsupported notation type: ' + this.notation.notationResponseType);
      }
    }
  }

}
