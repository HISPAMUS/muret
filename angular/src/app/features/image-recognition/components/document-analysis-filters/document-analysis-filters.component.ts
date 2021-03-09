import {
  AfterContentInit,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges
} from '@angular/core';
import {RegionType} from "../../../../core/model/entities/region-type";

@Component({
  selector: 'app-document-analysis-filters',
  templateUrl: './document-analysis-filters.component.html',
  styleUrls: ['./document-analysis-filters.component.css']
})
export class DocumentAnalysisFiltersComponent implements OnInit, OnChanges, AfterContentInit {
  @Input() regionTypes: RegionType[];
  @Input() addRegionTypeToFilter: RegionType; // on detecting change of this value, the region type is added to the filter
  @Output() onFilterChange = new EventEmitter<Set<string>>(); // emits the regionTypeFilterOut
  regionTypeFilterOut: Set<string>;
  mainRegionTypes: RegionType[]; // staff, lyrics
  otherRegionTypes: RegionType[]; // all the other ones

  public isCollapsed = true;

  constructor() {
    this.regionTypeFilterOut = new Set<string>();
  }

  ngOnInit(): void {
  }

  isStaff(regionType: RegionType) {
    return regionType.id === 2;
  }

  isLyrics(regionType: RegionType) {
    return regionType.id === 7;
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.regionTypes && this.regionTypes) {
      this.mainRegionTypes = [];
      this.otherRegionTypes = [];
      this.regionTypes.forEach(region => {
        if (this.isStaff(region) || this.isLyrics(region)) {
          this.mainRegionTypes.push(region);
        } else {
          this.otherRegionTypes.push(region);
        }
        if (!this.isStaff(region)) {
          this.regionTypeFilterOut.add(region.name); // check only staff
        }
      });
    }

    if (changes.addRegionTypeToFilter && this.addRegionTypeToFilter) {
      this.regionTypeFilterOut.delete(this.addRegionTypeToFilter.name);
      this.onFilterChange.emit(this.regionTypeFilterOut);
    }
  }

  ngAfterContentInit(): void {
    this.onFilterChange.emit(this.regionTypeFilterOut); // to propagate filter
  }

  beautifyRegionName(regionType: RegionType): string {
    if (regionType && regionType.name) {
      const result = regionType.name.replace(/_/g, ' ');
      return result.charAt(0).toUpperCase() + result.slice(1); // first char uppercase
    } else {
      return '';
    }
  }

  onLayerVisibilityChanged($event) {
    if ($event.target.checked) {
      this.regionTypeFilterOut.delete($event.target.name);
    } else {
      this.regionTypeFilterOut.add($event.target.name);
    }
    this.onFilterChange.emit(this.regionTypeFilterOut);
  }

  trackByRegionTypeFn(index, item: RegionType) {
    return item.id; // unique id corresponding to the item
  }

  selectAllNone($event)
  {
    let elements = document.querySelectorAll('input[type="checkbox"]');
    if($event.target.checked)
    {
      elements.forEach(element => {
        this.regionTypeFilterOut.delete(element["name"]);
        element["checked"] = true;
      });
    }
    else
    {
      elements.forEach(element => {
        this.regionTypeFilterOut.add(element["name"]);
        element["checked"] = false;
      });
    }
    this.onFilterChange.emit(this.regionTypeFilterOut);
  }


  getShowMoreLessString() {
    if (this.isCollapsed) {
      return 'Show more...';
    } else {
      return 'Show less...';
    }
  }

  isFilteredOut(regionType: RegionType) {
    return this.regionTypeFilterOut.has(regionType.name);
  }

  mustBeChecked(regionType: RegionType) { // if selected in the toolbar to be added it cannot be filtered out - then we disable it
    return this.addRegionTypeToFilter != null && this.addRegionTypeToFilter.id === regionType.id;
  }
}
