import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {RegionType} from "../../../../core/model/entities/region-type";

@Component({
  selector: 'app-document-analysis-filters',
  templateUrl: './document-analysis-filters.component.html',
  styleUrls: ['./document-analysis-filters.component.css']
})
export class DocumentAnalysisFiltersComponent implements OnInit, OnChanges {
  @Input() regionTypes: RegionType[];
  @Output() onShowRegionType = new EventEmitter<RegionType>();
  @Output() onHideRegionType = new EventEmitter<RegionType>();

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
      });
    }
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
      this.onHideRegionType.emit($event.target);
    } else {
      this.regionTypeFilterOut.add($event.target.name);
      this.onShowRegionType.emit($event.target);
    }
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
  }


  getShowMoreLessString() {
    if (this.isCollapsed) {
      return 'Show more...';
    } else {
      return 'Show less...';
    }
  }
}
