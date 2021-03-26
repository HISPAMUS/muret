import {Component, Input, OnInit, Output, EventEmitter, OnChanges, SimpleChanges} from '@angular/core';
import {RegionType} from "../../../../../../core/model/entities/region-type";

@Component({
  selector: 'app-document-analysis-toolbar',
  templateUrl: './document-analysis-toolbar.component.html',
  styleUrls: ['./document-analysis-toolbar.component.css']
})
export class DocumentAnalysisToolbarComponent implements OnInit, OnChanges {
  @Input() regionTypes: RegionType[];
  @Input() selectedRegion: RegionType | 'page' | 'several';
  @Output() onChangeRegion = new EventEmitter<RegionType | 'page'>();
  selectedRegionTypeID: number | 'page' | 'several';
  disableRegions: boolean = false; // it comes from the input (when a region is selected), and is used to disable changing a page into a region type

  constructor() {
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.selectedRegion) {
      if (this.selectedRegion) {
        if (this.selectedRegion == 'several' || this.selectedRegion == 'page') {
          this.selectedRegionTypeID = this.selectedRegion;
          this.disableRegions = true;
        } else {
          this.selectedRegionTypeID = this.selectedRegion.id;
          this.disableRegions = false;
        }
      } else {
        this.disableRegions = false;
      }
    }

    if (changes.regionTypes && this.regionTypes && !this.selectedRegionTypeID) {
      // initialize selecting staff
      this.selectedRegionTypeID = 2; // staff
      const staffRegionType = this.regionTypes.find(regionType => regionType.id === 2);
      if (!staffRegionType) {
        throw new Error('Cannot find region type staff with id = 2');
      }
      this.setRegionType(staffRegionType);
    }
  }

  setRegionType(regionType: RegionType) {
    setTimeout(()=>{
      this.onChangeRegion.emit(regionType);
    });
  }

  setPage() {
    this.onChangeRegion.emit('page');
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
