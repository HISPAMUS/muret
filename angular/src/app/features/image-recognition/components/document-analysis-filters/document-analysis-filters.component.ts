import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {RegionType} from "../../../../core/model/entities/region-type";

@Component({
  selector: 'app-document-analysis-filters',
  templateUrl: './document-analysis-filters.component.html',
  styleUrls: ['./document-analysis-filters.component.css']
})
export class DocumentAnalysisFiltersComponent implements OnInit {
  @Input() regionTypes: RegionType[];
  @Output() onShowRegionType = new EventEmitter<RegionType>();
  @Output() onHideRegionType = new EventEmitter<RegionType>();

  regionTypeFilterOut: Set<string>;

  constructor() {
    this.regionTypeFilterOut = new Set<string>();
  }

  ngOnInit(): void {
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
}
