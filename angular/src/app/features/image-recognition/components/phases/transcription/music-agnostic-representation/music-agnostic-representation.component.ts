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
import {SVGSet} from "../../../../../../core/model/restapi/svgset";
import {
  ImageRecognitionChangeSymbolsPosition,
  ImageRecognitionClassifyRegionEndToEnd, ImageRecognitionMoveSymbolsPosition
} from "../../../../store/actions/image-recognition.actions";
import {AgnosticSymbol} from "../../../../../../core/model/entities/agnostic-symbol";
import {PositionInStaffService} from "../../../../../../shared/services/position-in-staff.service";
import {ImageOverview} from "../../../../../../core/model/restapi/image-overview";

@Component({
  selector: 'app-music-agnostic-representation',
  templateUrl: './music-agnostic-representation.component.html',
  styleUrls: ['./music-agnostic-representation.component.css']
})
export class MusicAgnosticRepresentationComponent implements OnInit, OnDestroy {
  @Input() imageOverview: ImageOverview;
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
      this.store.dispatch(new ImageRecognitionChangeSymbolsPosition(this.selectedAgnosticSymbols, lineSpace));
    }
  }

  onMovePitch(displacement: number) {
    if (this.selectedAgnosticSymbols && this.selectedAgnosticSymbols.length > 0) {
      this.store.dispatch(new ImageRecognitionMoveSymbolsPosition(this.selectedAgnosticSymbols, displacement));
    }
  }
}