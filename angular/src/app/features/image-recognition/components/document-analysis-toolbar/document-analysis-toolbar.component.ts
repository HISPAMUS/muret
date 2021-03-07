import {Component, Input, OnInit, Output, EventEmitter, OnChanges, SimpleChanges} from '@angular/core';
import {RegionType} from "../../../../core/model/entities/region-type";

@Component({
  selector: 'app-document-analysis-toolbar',
  templateUrl: './document-analysis-toolbar.component.html',
  styleUrls: ['./document-analysis-toolbar.component.css']
})
export class DocumentAnalysisToolbarComponent implements OnInit, OnChanges {
  @Input() regionTypes: RegionType[];
  @Input() selectedRegion: RegionType | 'several';
  @Output() onChangeRegion = new EventEmitter<RegionType | 'page'>();
  selectedRegionTypeID: number | 'several';

  constructor() { }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.selectedRegion && this.selectedRegion) {
      if (this.selectedRegion == 'several') {
        this.selectedRegionTypeID = 'several';
      } else {
        this.selectedRegionTypeID = this.selectedRegion.id;
      }
    }
  }

  setRegionType(regionType: RegionType) {
    this.onChangeRegion.emit(regionType);
  }

  trackByRegionTypeFn(index, item: RegionType) {
    return item.id; // unique id corresponding to the item
  }

  beautifyRegionName(regionType: RegionType): string {
    if (regionType && regionType.name) {
      const result = regionType.name.replace(/_/g, ' ');
      return result.charAt(0).toUpperCase() + result.slice(1); // first char uppercase
    } else {
      return '';
    }
  }

  getSortedRegionTypes() {
    if (this.regionTypes) {
      return this.regionTypes.slice().sort((a,b) => a.name.localeCompare(b.name));
    } else {
      return [];
    }
  }

}
