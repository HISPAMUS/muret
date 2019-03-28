import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';
import {Store} from '@ngrx/store';
import {Observable, Subscription} from 'rxjs';
import {
  selectAgnosticSymbols,
  selectSelectedSymbol,
} from '../../store/selectors/agnostic-representation.selector';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {SVGSet} from '../../model/svgset';
import {SelectSymbol} from '../../store/actions/agnostic-representation.actions';
import {AgnosticTypeSVGPath} from '../../model/agnostic-type-svgpath';

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
  @Input() mode: 'eIdle' | 'eInserting' | 'eEditing' | 'eSelecting';
  @Input() svgAgnosticSymbolSet: SVGSet;

  em = 100; // TODO variable - ver también el cálculo del tamaño de los use en el svg
  margin = 1 * this.em;

  staffSpaceHeight: number;
  cursorClass: string;
  viewBox: string;
  height: number;
  width: number;
  staffLines: StaffLine[]; // TODO El nº de pentagramas debería depender del tipo de partitura
  private staffBottomLineY: number;

  agnosticSymbols$: Observable<AgnosticSymbol[]>;
  private selectedSymbolSubscription: Subscription;
  private selectedSymbol: AgnosticSymbol;

  constructor(private store: Store<any>) {
    this.agnosticSymbols$ = store.select(selectAgnosticSymbols);
    this.selectedSymbolSubscription = store.select(selectSelectedSymbol).subscribe(next => {
      this.selectedSymbol = next as any as AgnosticSymbol;
    });
  }

  ngOnInit() {
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
      }
    }
  }


  ngOnChanges(changes: SimpleChanges): void {
    // this.viewBox = `0 0 ${this.width} ${this.margin * 2 + this.em}`;
    // in order to use the same horizontal scale of the selected region (see AgnosticRepresentationComponent) we use its same x viewBox
    this.width = this.regionCropped.toX - this.regionCropped.fromX;
    this.height = this.margin * 2 + this.em;
    this.viewBox = `${this.regionCropped.fromX} 0 ${this.width} ${this.height}`;
  }

  ngOnDestroy(): void {
    this.selectedSymbolSubscription.unsubscribe();
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

  trackByAgnosticSymbolTypeFn(index, item: AgnosticTypeSVGPath) {
    return index;
  }

  computeAgnosticStaffSymbolY(symbol: AgnosticSymbol): number {
    const lineSpace = this.positionInStaffToLineSpace(symbol.positionInStaff);
    const heightDifference = -(this.staffSpaceHeight * (lineSpace / 2.0));
    const y = this.staffBottomLineY  + heightDifference;
    return y;
  }

  private positionInStaffToLineSpace(positionInStaff: string): number {
    const value = Number(positionInStaff.substr(1));
    if (positionInStaff.charAt(0) === 'L') {
      return (value - 1) * 2;
    } else if (positionInStaff.charAt(0) === 'S') {
      return (value) * 2 - 1;
    } else {
      throw new Error('Invalid positionInStaff, it should start with L or S: ' + positionInStaff);
    }
  }

  /*computeSVGSymbolViewBox(svgSet: SVGSet, svgSymbol: AgnosticTypeSVGPath) {
    return `0 ${-(svgSet.em - svgSet.descent)} ${svgSet.em + svgSymbol.horizAdvX} ${svgSet.em}`;
  }*/

  onMouseDown($event) {
  }

  onMouseUp($event) {
  }

  onMouseMove($event) {
  }

  getColor(symbol: AgnosticSymbol): string {
    if (this.selectedSymbol === symbol) {
      return SELECTED_COLOR;
    } else {
      return UNSELECTED_COLOR;
    }
  }

  onSymbolMouseDown(agnosticSymbol: AgnosticSymbol) {
    if (this.mode === 'eEditing') {
      this.store.dispatch(new SelectSymbol(agnosticSymbol.id));
    }
  }
}
