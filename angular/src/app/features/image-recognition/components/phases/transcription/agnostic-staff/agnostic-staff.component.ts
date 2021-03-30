import {
  Component,
  ElementRef,
  EventEmitter,
  HostListener,
  Input,
  OnChanges,
  OnDestroy,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild
} from '@angular/core';
import {Store} from '@ngrx/store';
import {Subscription} from 'rxjs';
import {BoundingBox} from "../../../../../../core/model/entities/bounding-box";
import {AgnosticSymbol} from "../../../../../../core/model/entities/agnostic-symbol";
import {PositionInStaffService} from "../../../../../../shared/services/position-in-staff.service";
import {
  selectImageRecognitionSelectedAgnosticSymbols,
} from "../../../../store/selectors/image-recognition.selector";
import {
  ImageRecognitionChangeSymbolX,
  ImageRecognitionSelectAgnosticSymbols
} from "../../../../store/actions/image-recognition.actions";
import {Shape} from "../../../../../../svg/model/shape";
import {SVGSet} from "../../../../../../core/model/restapi/svgset";
import {AgnosticOrSemanticTypeSVGPath} from "../../../../../../core/model/restapi/agnostic-or-semantic-type-s-v-g-path";

interface StaffLine {
  index: number;
  y: number;
}

const SELECTED_COLOR = 'red';
const UNSELECTED_COLOR = 'black';

@Component({
  selector: 'app-agnostic-staff',
  templateUrl: './agnostic-staff.component.html',
  styleUrls: ['./agnostic-staff.component.css']
})
export class AgnosticStaffComponent implements OnInit, OnDestroy, OnChanges {
  @Input() regionCropped: BoundingBox; // see ngOnInit below
  @Input() svgAgnosticSymbolSet: SVGSet;
  @Input() agnosticSymbols: AgnosticSymbol[];
  @Output() commentClicked = new EventEmitter<AgnosticSymbol>();

  @Output() modeChange = new EventEmitter(); // must have this name in order to be input / output
  @Output() selectedShapesChange = new EventEmitter();

  modeValue: 'eAdding' | 'eEditing' | 'eSelecting';
  selectedShapesValue: Shape[];


  symbolHeight = 50; // 87.5px // TODO
  annotationHeight = 25; // TODO
  em = 50; // TODO variable - ver también el cálculo del tamaño de los use en el svg
  LEDGER_LINE_OFFSET: number = this.em / 4;
  LEDGER_LINE_WIDTH: number = this.em / 1.5;

  @ViewChild('agnosticStaff', {static: true}) agnosticStaff: ElementRef;

  margin: number;

  staffSpaceHeight: number;
  cursorClass: string;
  viewBox: string;
  height: number;
  width: number;
  staffLines: StaffLine[]; // TODO El nº de pentagramas debería depender del tipo de partitura
  private staffBottomLineY: number;
  private staffTopLineY: number;

  private selectedSymbolSubscription: Subscription;
  private selectedSymbolIDs: Set<number> = new Set<number>();

  private movingSymbolOriginalX: number;
  private movingSymbolX: number;
  private movingSymbol: AgnosticSymbol;

  constructor(private store: Store<any>, private positionInStaffService: PositionInStaffService) {
    this.modeValue = 'eSelecting';
    this.selectedSymbolSubscription = store.select(selectImageRecognitionSelectedAgnosticSymbols).subscribe(next => {
      this.selectedSymbolIDs.clear();
      if (next) {
        next.forEach(agnosticSymbol => {
          this.selectedSymbolIDs.add(agnosticSymbol.id);
        });
      }
      // = next as any as AgnosticSymbol;
    });

  }

  ngOnInit() {
    this.margin = this.em;

    this.computeViewBox();

    this.staffLines = new Array();
    this.staffSpaceHeight = this.em / 4;
    for (let i = 4; i >= 0; i--) {
      const y = this.margin + this.staffSpaceHeight * i;
      const line: StaffLine = {
        index: 4 - i,
        y
      };
      this.staffLines.push(line);

      if (i === 4) {
        this.staffBottomLineY = line.y;
      } else if (i === 0) {
        this.staffTopLineY = line.y;
      }
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.computeViewBox();
  }

  ngOnDestroy(): void {
    this.selectedSymbolSubscription.unsubscribe();
  }

  @Input()
  get mode() {
    return this.modeValue;
  }

  set mode(val) {
    if (this.modeValue != val) {
      this.modeValue = val;
      this.modeChange.emit(this.modeValue);
    }
  }


  @Input()
  get selectedShapes() {
    return this.selectedShapesValue;
  }

  set selectedShapes(val) {
    if (this.selectedShapesValue != val) {
      this.selectedShapesValue = val;
      this.selectedShapesChange.emit(this.selectedShapesValue);
    }
  }

  trackByShapeFn(index, item: StaffLine) {
    return item.index;
  }

  trackBySymbolFn(index, item: AgnosticSymbol) {
    return item.id;
  }

  trackByLineFn(index, item: StaffLine) {
    return item.index;
  }

  trackByAgnosticSymbolTypeFn(index, item: AgnosticOrSemanticTypeSVGPath) {
    return index;
  }

  trackByLedgerLineFn(index, item: number) {
    return item;
  }

  computeAgnosticStaffSymbolY(symbol: AgnosticSymbol): number {
    const lineSpace = this.positionInStaffService.positionInStaffToLineSpace(symbol.positionInStaff);
    const heightDifference = -(this.staffSpaceHeight * (lineSpace / 2.0));
    const y = this.staffBottomLineY  + heightDifference;
    return y;
  }


  computeLedgerLines(agnosticSymbol: AgnosticSymbol, lines: number): number {
    const lineSpace = this.positionInStaffService.positionInStaffToLineSpace(agnosticSymbol.positionInStaff);
    if (lineSpace < 0) {
      return -lineSpace / 2;
    } else if (lineSpace > (lines - 1) * 2) {
      return -(lineSpace - (lines - 1) * 2) / 2;
    } else {
      return 0;
    }
  }

  /**
   * Returns the positions of the ledger lines
   */
  getLedgerLines(agnosticSymbol: AgnosticSymbol): number[] {
    const result = new Array<number>();
    const nll = this.computeLedgerLines(agnosticSymbol, 5);

    if (nll < 0) {
      for (let i = 1; i <= -nll; i++) {
        const y = this.staffTopLineY - i * this.staffSpaceHeight;
        result.push(y);
      }
    } else if (nll > 0) {
      for (let i = 1; i <= nll; i++) {
        const y = this.staffBottomLineY + i * this.staffSpaceHeight;
        result.push(y);
      }
    }
    return result;
  }


  getColor(symbol: AgnosticSymbol): string {
    if (this.selectedSymbolIDs.has(symbol.id)) {
      return SELECTED_COLOR;
    } else {
      return UNSELECTED_COLOR;
    }
  }

  private selectSymbolRequest(agnosticSymbol: AgnosticSymbol) {
    const selected: AgnosticSymbol[] = [agnosticSymbol];
    this.store.dispatch(new ImageRecognitionSelectAgnosticSymbols(selected));
  }

  onDblClick(agnosticSymbol: AgnosticSymbol) {
    this.selectSymbolRequest(agnosticSymbol);
  }




  private computeViewBox() {
    /*OLD // this.viewBox = `0 0 ${this.width} ${this.margin * 2 + this.em}`;
    // in orderEntities to use the same horizontal scale of the selected region (see AgnosticRepresentationComponent) we use its same x viewBox
    this.width = this.regionCropped.toX - this.regionCropped.fromX;
    this.height = this.margin * 2 + this.em;

    const viewBoxHeight =  this.regionCropped.toY - this.regionCropped.fromY;
    this.viewBox = `${this.regionCropped.fromX} 0 ${this.width} ${viewBoxHeight}`;
    // this.viewBox = `${this.regionCropped.fromX} 0 ${this.width} ${this.height}`;*/

    const w = this.agnosticStaff.nativeElement.clientWidth;

    this.width = w;
    this.height = this.margin * 2 + this.em;

    this.viewBox = `0 0 ${this.width} ${this.height}`;
  }

  @HostListener('window:resize', ['$event'])
  onResize($event) {
    this.computeViewBox();
  }

  hasComment(agnosticSymbol: AgnosticSymbol) {
    return agnosticSymbol.comments != null;
  }

  doCommentClicked(agnosticSymbol: AgnosticSymbol) {
    this.commentClicked.emit(agnosticSymbol);
  }

  getAgnosticX(agnosticSymbol: AgnosticSymbol) {
    let x: number;
    if (agnosticSymbol.boundingBox) {
      x = agnosticSymbol.boundingBox.fromX;
    } else {
      x = agnosticSymbol.approximateX;
    }
    return x;
  }
  getX(agnosticSymbol: AgnosticSymbol) {
    if (this.movingSymbol == agnosticSymbol && this.movingSymbolX) {
      return this.movingSymbolX;
    } else {
      const x = this.getAgnosticX(agnosticSymbol);
      return this.width * (x - this.regionCropped.fromX) / (this.regionCropped.toX - this.regionCropped.fromX);
    }
  }

  onSymbolMouseDown(agnosticSymbol: AgnosticSymbol) {
    this.selectSymbolRequest(agnosticSymbol);
    this.movingSymbol = agnosticSymbol;
    this.movingSymbolOriginalX = this.getX(this.movingSymbol);

    // console.log('---------');
    // console.log('---------');
    // console.log('DOWN Agnostic x: ' + this.getAgnosticX(this.movingSymbol));
    // console.log('DOWN Screen x: ' + this.getX(this.movingSymbol));

  }

  onSymbolMouseMove(mouseEvent: MouseEvent) {
    this.movingSymbolX = mouseEvent.offsetX;
  }

  onSymbolMouseUp() {
    //console.log('UP Agnostic x: ' + this.getAgnosticX(this.movingSymbol));
    //console.log('UP Screen x: ' + this.getX(this.movingSymbol));

   if (this.movingSymbolX && this.movingSymbolOriginalX && Math.abs(this.movingSymbolX - this.movingSymbolOriginalX) > 5) { //

     //return this.width * (x - this.regionCropped.fromX) / (this.regionCropped.toX - this.regionCropped.fromX);
      const newX = (this.regionCropped.toX - this.regionCropped.fromX) * this.movingSymbolX / this.width + this.regionCropped.fromX;
      this.store.dispatch(new ImageRecognitionChangeSymbolX(this.movingSymbol, newX));
      //console.log('CAMBIA a ' + newX);
      //return this.width * (x - this.regionCropped.fromX) / (this.regionCropped.toX - this.regionCropped.fromX);
    }

    this.movingSymbol = null;
    this.movingSymbolX = null;
    this.movingSymbolOriginalX = null;
  }

}
