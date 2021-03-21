import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {SVGSet} from "../../../../../agnostic-representation/model/svgset";
import {KeyValue} from "@angular/common";
import {AgnosticOrSemanticSymbolAndPosition} from "../../../../../agnostic-representation/model/agnostic-or-semantic-symbol-and-position";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {Subscription} from "rxjs";
import {selectImageRecognitionSelectedAgnosticSymbols} from "../../../../store/selectors/image-recognition.selector";
import {AgnosticOrSemanticTypeSVGPath} from "../../../../../agnostic-representation/model/agnostic-or-semantic-type-s-v-g-path";
import {ImageRecognitionChangeSymbol} from "../../../../store/actions/image-recognition.actions";
import {AgnosticSymbol} from "../../../../../../core/model/entities/agnostic-symbol";

@Component({
  selector: 'app-agnostic-toolbar',
  templateUrl: './agnostic-toolbar.component.html',
  styleUrls: ['./agnostic-toolbar.component.css']
})
export class AgnosticToolbarComponent implements OnInit, OnDestroy {
  @Input() svgSet: SVGSet;
  selectedAgnosticSymbolType: string;
  private selectedAgnosticSymbolsSubscription: Subscription;
  private selectedAgnosticSymbols: AgnosticSymbol[];

  agnosticToolbarFilters: Array<KeyValue<string, string>> = // map<values, titles> - initialized in constructor
    [
      {key: "clefsmeters", value: "Clefs Meters"},
      {key: "note.", value: "Notes"},
      {key: "note.beam", value: "Beamed notes"},
      {key: "rest", value: "Rests"},
      {key: "accidental.", value: "Accidentals"},
      {key: "other", value: "Other"}
    ];

  classifiedSymbols: AgnosticOrSemanticSymbolAndPosition[];
  constructor(private store: Store<ImageRecognitionState>) { }

  ngOnInit(): void {
    this.selectedAgnosticSymbolsSubscription = this.store.select(selectImageRecognitionSelectedAgnosticSymbols).subscribe(next => {
      if (next) {
        this.selectedAgnosticSymbols = next;
        //TODO Cojo sólo el primero
        if (next.length > 0) {
          this.selectedAgnosticSymbolType = next[0].agnosticSymbolType;
        }
      }
    });
  }

  ngOnDestroy(): void {
    this.selectedAgnosticSymbolsSubscription.unsubscribe();
  }

  onAgnosticSymbolTypeSelected(agnosticOrSemanticTypeSVGPath: AgnosticOrSemanticTypeSVGPath) {
    if (this.selectedAgnosticSymbols && this.selectedAgnosticSymbols.length > 0) {
      //TODO Cambiar varios símbolos - ahora cambiamos sólo el primero
      const selectedSymbol = this.selectedAgnosticSymbols[0];
      this.store.dispatch(new ImageRecognitionChangeSymbol(selectedSymbol, agnosticOrSemanticTypeSVGPath.agnosticOrSemanticTypeString, selectedSymbol.positionInStaff));
    }
  }


}
