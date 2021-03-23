import {Component, Input, OnInit} from '@angular/core';
import {SVGSet} from "../../../../../../core/model/restapi/svgset";

@Component({
  selector: 'app-transcription-tools',
  templateUrl: './transcription-tools.component.html',
  styleUrls: ['./transcription-tools.component.css']
})
export class TranscriptionToolsComponent implements OnInit {
  @Input() svgSet: SVGSet;

  encodingPaneType: 'none' | 'manual' | 'mei' | 'toolbar' | 'agnostic';

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

  showSemanticToolbar() {
    this.encodingPaneType = 'toolbar';
  }
}
