import {
  AfterViewInit,
  Component,
  ElementRef,
  Input,
  OnChanges,
  OnDestroy,
  OnInit,
  SimpleChanges,
  ViewChild
} from '@angular/core';
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
export class NotationComponent implements OnInit, OnChanges, OnDestroy, AfterViewInit {
  @Input() notation: Notation;
  @Input() selectedItem: string;

  notationAsSVG: any;
  private serverErrorSubscription: Subscription;

  @ViewChild("verovioDiv") verovioDiv: ElementRef;

  constructor(private notationService: NotationService, private store: Store<any>, private showErrorService: ShowErrorService) { }

  ngOnInit() {
    this.serverErrorSubscription = this.store.select(selectSemanticRepresentationServerError).subscribe(next => {
      if (next) {
        this.showErrorService.warning(next);
        this.store.dispatch(new ResetSemanticRepresentationServerError());
      }
    });
  }


  ngAfterViewInit(): void {
    // until here the querySelector cannot be used
    //const element2: HTMLElement = this.verovioDiv.nativeElement.querySelector('#L3') as HTMLElement;
    //element2.classList.add('selectedVerovioItem');
    //console.log(element2);
  }


  ngOnDestroy(): void {
    this.serverErrorSubscription.unsubscribe();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.notation) {
      if (this.notation.notationResponseType === 'mei') {
        this.notationAsSVG = this.notationService.renderStaff(this.notation.content);
      } else if (this.notation.notationResponseType === 'svg') {
        this.notationAsSVG = this.notation.content;
      } else {
        throw new Error('Unsupported notation type: ' + this.notation.notationResponseType);
      }
    } else if (changes.selectedItem) {
      this.changeSelectedItem(changes.selectedItem.previousValue, false);
      this.changeSelectedItem(changes.selectedItem.currentValue, true);
    }
  }

  private changeSelectedItem(id: string, add: boolean) {
    const selectedItem: HTMLElement = this.verovioDiv.nativeElement.querySelector('#L' + id) as HTMLElement;
    if (selectedItem) {
      if (add) {
        selectedItem.classList.add('selectedVerovioItem');
      } else {
        selectedItem.classList.remove('selectedVerovioItem');
      }
    }
  }

}
