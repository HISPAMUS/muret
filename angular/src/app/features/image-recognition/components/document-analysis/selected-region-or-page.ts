import {Region} from "../../../../core/model/entities/region";
import {Page} from "../../../../core/model/entities/page";

export interface SelectedRegionOrPage {
  page?: Page;
  region?: Region;
}
