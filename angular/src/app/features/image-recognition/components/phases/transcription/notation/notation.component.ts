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
import {Subscription} from 'rxjs';
import {Notation} from "../../../../../../shared/services/notation";
import {NotationService} from "../../../../../../shared/services/notation.service";
import {ShowErrorService} from "../../../../../../core/services/show-error.service";

// Verovio integration based on the code in https://github.com/deanmalone/PianoPlay
@Component({
  selector: 'app-notation',
  templateUrl: './notation.component.html',
  styleUrls: ['./notation.component.css']
})
export class NotationComponent implements OnInit, OnChanges, OnDestroy, AfterViewInit {
  @Input() notation: Notation;
  @Input() selectedItem: string;
  @Output() onItemSelected = new EventEmitter<string>();

  notationAsSVG: any;

  @ViewChild("verovioDiv") verovioDiv: ElementRef;

  constructor(private notationService: NotationService, private store: Store<any>, private showErrorService: ShowErrorService) { }

  ngOnInit() {
  }


  ngOnDestroy(): void {
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


  ngAfterViewInit(): void {
    // until here the querySelector cannot be used
    //const groups: HTMLElement = this.verovioDiv.nativeElement.querySelectorAll('g') as HTMLElement;

    // we use the lambda notation to maintain the this value, if the function() {} notation is used,
    // the this accesibility is lost
    this.verovioDiv.nativeElement.querySelectorAll('g').forEach( (item) => {
      if (item.id && item.id.startsWith('L')) { // the ID of elements starts with an L (see Semantic2IMCore) convert method
        item.addEventListener('mouseover', (event) => {
          if (item.id) {
            this.onItemSelected.emit(item.id);
          }
        });
      }
    });
  }

}
