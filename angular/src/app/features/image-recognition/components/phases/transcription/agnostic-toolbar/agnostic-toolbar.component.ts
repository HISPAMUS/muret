import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {KeyValue} from "@angular/common";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {Subscription} from "rxjs";
import {selectImageRecognitionSelectedAgnosticSymbols} from "../../../../store/selectors/image-recognition.selector";
import {AgnosticSymbol} from "../../../../../../core/model/entities/agnostic-symbol";
import {SVGSet} from "../../../../../../core/model/restapi/svgset";
import {AgnosticOrSemanticTypeSVGPath} from "../../../../../../core/model/restapi/agnostic-or-semantic-type-s-v-g-path";
import {AgnosticOrSemanticSymbolAndPosition} from "../../../../../../core/model/restapi/agnostic-or-semantic-symbol-and-position";
import {ImageRecognitionChangeSymbolsType} from "../../../../store/actions/image-recognition.actions";

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
      //{key: "frequent", value: "Frequent"},
      {key: "clefsmeters", value: "Clefs | Meters"},
      {key: "note.", value: "Notes"},
      {key: "note.beam", value: "Beamed notes"},
      {key: "rest", value: "Rests | Accidentals"},
      //{key: "accidental.", value: "Accidentals"},
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
      this.store.dispatch(new ImageRecognitionChangeSymbolsType(this.selectedAgnosticSymbols, agnosticOrSemanticTypeSVGPath.agnosticOrSemanticTypeString));
    }
  }


}
