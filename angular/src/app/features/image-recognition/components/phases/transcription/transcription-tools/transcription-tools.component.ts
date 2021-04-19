import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {SVGSet} from "../../../../../../core/model/restapi/svgset";

@Component({
  selector: 'app-transcription-tools',
  templateUrl: './transcription-tools.component.html',
  styleUrls: ['./transcription-tools.component.css']
})
export class TranscriptionToolsComponent implements OnInit {
  @Input() svgSet: SVGSet;

  encodingPaneType: 'none' | 'manual' | 'mei' | 'toolbar' | 'agnostic' | 'paec';

  constructor() { }

  ngOnInit(): void {
  }

  isAgnosticCollapsed() {
    return this.encodingPaneType !== 'agnostic';
  }

  isManualEntryCollapsed() {
    return this.encodingPaneType !== 'manual';
  }

  isMEICollapsed() {
    return this.encodingPaneType !== 'mei';
  }

  isPAECCollapsed() {
    return this.encodingPaneType !== 'paec';
  }

  isSemanticToolbarCollapsed() {
    return this.encodingPaneType !== 'toolbar';
  }

  isManualEntrySelected() {
    return this.encodingPaneType === 'manual';
  }

  isAgnosticSelected() {
    return this.encodingPaneType === 'agnostic';
  }

  isMEISelected() {
    return this.encodingPaneType === 'mei';
  }

  isPAECSelected() {
    return this.encodingPaneType === 'paec';
  }


  isToolbarSelected() {
    return this.encodingPaneType === 'toolbar';
  }

  showAgnostic() {
    this.encodingPaneType = 'agnostic';
  }

  showManualEntry() {
    this.encodingPaneType = 'manual';
  }

  showMEI() {
    this.encodingPaneType = 'mei';
  }

  showPAEC() {
    this.encodingPaneType = 'paec';
  }

  showSemanticToolbar() {
    this.encodingPaneType = 'toolbar';
  }

}
