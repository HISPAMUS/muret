import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ImageRecognitionProgressStatus} from "../../../core/model/entities/image-recognition-progress-status";

@Component({
  selector: 'app-document-phases',
  templateUrl: './image-phases.component.html',
  styleUrls: ['./image-phases.component.css']
})
export class ImagePhasesComponent implements OnInit, OnChanges {
  @Input() imageID: number;
  @Input() nextImageID: number;
  @Input() prevImageID: number;
  @Input() size: string;
  @Input() imageRecognitionProgressStatuses: ImageRecognitionProgressStatus[];
  @Input() selectedPhase: string;

  phaseStatus: Map<string, string>;

  constructor() { }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.imageRecognitionProgressStatuses && this.imageRecognitionProgressStatuses) {
      this.phaseStatus = new Map<string, string>();
      this.imageRecognitionProgressStatuses.forEach(ps => {
        this.phaseStatus.set(ps.phase, ps.status);
      });
    }
  }

  getPhaseStatus(phase: string): string {
    if (this.phaseStatus) {
      const result = this.phaseStatus.get(phase);
      return result;
    }
  }
}
