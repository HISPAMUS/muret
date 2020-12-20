import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {NotationService} from '../../../semantic-representation/services/notation.service';
import {Observable, Subscription} from 'rxjs';
import {Store} from '@ngrx/store';
import {DocumentState} from '../../store/state/document.state';
import {selectMEI} from '../../store/selectors/document.selector';

@Component({
  selector: 'app-meiscore-viewer',
  templateUrl: './meiscore-viewer.component.html',
  styleUrls: ['./meiscore-viewer.component.css']
})
export class MEIScoreViewerComponent implements OnInit, OnDestroy {
  notationAsSVG: any;
  meiSubscription: Subscription;

  constructor(private notationService: NotationService, private store: Store<DocumentState>) { }

  ngOnInit() {
    // data is stored by DocumentScoreViewerAndExporterComponent in store
    this.meiSubscription = this.store.select(selectMEI).subscribe(next => {
      if (next) {
        this.notationAsSVG = this.notationService.renderScore(next);
      }
    });
  }

  ngOnDestroy(): void {
    this.meiSubscription.unsubscribe();
  }

}
