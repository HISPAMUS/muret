import {
  AfterViewInit,
  Component,
  ElementRef, EventEmitter,
  Input,
  OnChanges,
  OnDestroy,
  OnInit, Output,
  SimpleChanges,
  ViewChild
} from '@angular/core';
import {Store} from '@ngrx/store';
import {Notation} from "../../../../../../shared/services/notation";
import {NotationService} from "../../../../../../shared/services/notation.service";
import {ShowErrorService} from "../../../../../../core/services/show-error.service";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {ImageRecognitionSelectNotationSymbol} from "../../../../store/actions/image-recognition.actions";
import {Subscription} from "rxjs";
import {selectImageRecognitionSelectedNotationSymbol} from "../../../../store/selectors/image-recognition.selector";

// Verovio integration based on the code in https://github.com/deanmalone/PianoPlay
@Component({
  selector: 'app-semantic-notation',
  templateUrl: './semantic-notation.component.html',
  styleUrls: ['./semantic-notation.component.css']
})
export class SemanticNotationComponent implements OnInit, OnChanges, OnDestroy, AfterViewInit {
  @Input() notation: Notation;

  notationAsSVG: any;

  @ViewChild("verovioDiv") verovioDiv: ElementRef;

  private selectedNotationSymbolSubscription: Subscription;
  private lastSelectedNotationSymbolID: string;

  constructor(private notationService: NotationService, private store: Store<ImageRecognitionState>, private showErrorService: ShowErrorService) { }

  ngOnInit() {
    this.selectedNotationSymbolSubscription = this.store.select(selectImageRecognitionSelectedNotationSymbol).subscribe(next => {
      if (next) {
        this.onNotationSymbolSelected(next);
      }
    });

  }


  ngOnDestroy(): void {
    this.selectedNotationSymbolSubscription.unsubscribe();
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
    }
  }

  private changeSelectedItem(id: string, add: boolean) {
    if (this.verovioDiv.nativeElement) {
      const selectedItem: HTMLElement = this.verovioDiv.nativeElement.querySelector('#' + id) as HTMLElement;
      if (selectedItem) {
        if (add) {
          if (!selectedItem.classList.contains('selectedVerovioItem')) {
            selectedItem.classList.add('selectedVerovioItem');
          }
        } else {
          selectedItem.classList.remove('selectedVerovioItem');
        }
      }
    }
  }


  ngAfterViewInit(): void {
    // until here the querySelector cannot be used
    //const groups: HTMLElement = this.verovioDiv.nativeElement.querySelectorAll('g') as HTMLElement;

    // we use the lambda notation to maintain the this value, if the function() {} notation is used,
    // the this accesibility is lost
    this.verovioDiv.nativeElement.querySelectorAll('g').forEach( (item) => {
      if (item.id && item.id.startsWith('L')) { // the ID of elements starts with an L (see Semantic2IMCore) convert method
        item.addEventListener('mousedown', (event) => {
          if (item.id) {
            this.onItemSelected(item.id);
          }
        });
      }
    });
  }

  private onItemSelected(id: string) {
    this.store.dispatch(new ImageRecognitionSelectNotationSymbol(id));
  }

  private onNotationSymbolSelected(notationSymbolID: string) {
    if (this.lastSelectedNotationSymbolID) {
      this.changeSelectedItem(this.lastSelectedNotationSymbolID, false);
    }
    this.changeSelectedItem(notationSymbolID, true);
    this.lastSelectedNotationSymbolID = notationSymbolID;
  }
}
