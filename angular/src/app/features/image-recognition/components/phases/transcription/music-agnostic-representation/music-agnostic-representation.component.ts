import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Region} from "../../../../../../core/model/entities/region";
import {SafeResourceUrl} from "@angular/platform-browser";
import {Observable, Subscription} from "rxjs";
import {ClassifierModel} from "../../../../../../core/model/entities/classifier-model";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {
  selectImageRecognitionAgnosticEnd2EndClassifierModels,
  selectImageRecognitionAgnosticSymbolsClassifierModels, selectImageRecognitionSelectedAgnosticSymbols
} from "../../../../store/selectors/image-recognition.selector";
import {Shape} from "../../../../../../svg/model/shape";
import {SVGSet} from "../../../../../agnostic-representation/model/svgset";
import {
  ImageRecognitionChangeSymbol,
  ImageRecognitionClassifyRegionEndToEnd
} from "../../../../store/actions/image-recognition.actions";
import {AgnosticOrSemanticTypeSVGPath} from "../../../../../agnostic-representation/model/agnostic-or-semantic-type-s-v-g-path";
import {AgnosticOrSemanticSymbolAndPosition} from "../../../../../agnostic-representation/model/agnostic-or-semantic-symbol-and-position";
import {AgnosticSymbol} from "../../../../../../core/model/entities/agnostic-symbol";
import {ChangeSymbol} from "../../../../../agnostic-representation/store/actions/agnostic-representation.actions";
import {PositionInStaffService} from "../../../../../../shared/services/position-in-staff.service";
import {KeyValue} from "@angular/common";

@Component({
  selector: 'app-music-agnostic-representation',
  templateUrl: './music-agnostic-representation.component.html',
  styleUrls: ['./music-agnostic-representation.component.css']
})
export class MusicAgnosticRepresentationComponent implements OnInit, OnDestroy {
  @Input() region: Region;
  @Input() loadedImage: SafeResourceUrl;
  @Input() svgSet: SVGSet;

  agnosticSymbolClassifiers$: Observable<ClassifierModel[]>;
  agnosticEndToEndClassifiers$: Observable<ClassifierModel[]>;
  private selectedAgnosticSymbolsSubscription: Subscription;

  mode: 'eInserting' | 'eEditing' | 'eSelecting';
  selectedAgnosticShapes: Shape[] = [];


  private selectedAgnosticSymbols: AgnosticSymbol[];

  constructor(private store: Store<ImageRecognitionState>, private positionInStaffService: PositionInStaffService) {
    this.mode = 'eSelecting';

    this.agnosticSymbolClassifiers$ = this.store.select(selectImageRecognitionAgnosticSymbolsClassifierModels);
    this.agnosticEndToEndClassifiers$ = this.store.select(selectImageRecognitionAgnosticEnd2EndClassifierModels);
    this.selectedAgnosticSymbolsSubscription = this.store.select(selectImageRecognitionSelectedAgnosticSymbols).subscribe(next => {
      if (next) {
        this.selectedAgnosticSymbols = next;
      }
    });
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.selectedAgnosticSymbolsSubscription.unsubscribe();
  }

  onExecuteAgnosticClassifier(classifierModel: ClassifierModel, region: Region) {
    this.store.dispatch(new ImageRecognitionClassifyRegionEndToEnd(classifierModel.id, region.id));
  }


  onChangeLineSpace(lineSpace: string) {
    if (this.selectedAgnosticSymbols && this.selectedAgnosticSymbols.length > 0) {
      //TODO Cambiar varios símbolos - ahora cambiamos sólo el primero
      const selectedSymbol = this.selectedAgnosticSymbols[0];
      this.store.dispatch(new ImageRecognitionChangeSymbol(selectedSymbol, selectedSymbol.agnosticSymbolType, lineSpace));
    }
  }

  onMovePitch(displacement: number) {
    if (this.selectedAgnosticSymbols && this.selectedAgnosticSymbols.length > 0) {
      //TODO Cambiar varios símbolos - ahora cambiamos sólo el primero
      const selectedSymbol = this.selectedAgnosticSymbols[0];
      const positionInStaff = selectedSymbol.positionInStaff;
      const newPositionInStaff = this.positionInStaffService.movePitch(positionInStaff, displacement);

      this.store.dispatch(new ImageRecognitionChangeSymbol(selectedSymbol, selectedSymbol.agnosticSymbolType, newPositionInStaff));
    }
  }
}
