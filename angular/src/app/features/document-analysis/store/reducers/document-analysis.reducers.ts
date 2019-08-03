import {DocumentAnalysisState, initialDocumentAnalysisState} from '../state/document-analysis.state';
import {DocumentAnalysisActions, DocumentAnalysisActionTypes} from '../actions/document-analysis.actions';
import {Page} from '../../../../core/model/entities/page';
import deepcopy from 'ts-deepcopy';

export function documentAnalysisReducers(state = initialDocumentAnalysisState, action: DocumentAnalysisActions): DocumentAnalysisState {
  switch (action.type) {
    case DocumentAnalysisActionTypes.GetRegionTypesSuccess: {
      return {
        ...state,
        regionTypes: action.regionTypes
      };
    }
    case DocumentAnalysisActionTypes.GetImageProjection: { // reset before downloading new elements
      return {
        ...initialDocumentAnalysisState
      };
    }
    case DocumentAnalysisActionTypes.GetImageProjectionSuccess: {
      return {
        ...state,
        imageWidth: action.documentAnalysisImageProjection.width,
        imageHeight: action.documentAnalysisImageProjection.height,
        filename: action.documentAnalysisImageProjection.filename,
        pages: action.documentAnalysisImageProjection.pages,
        imagePart: action.documentAnalysisImageProjection.part,
        documentType: {
          manuscriptType: action.documentAnalysisImageProjection.manuscriptType,
          notationType: action.documentAnalysisImageProjection.notationType
        }
      };
    }
    case DocumentAnalysisActionTypes.GetImagePartSuccess: {
      return {
        ...state,
        imagePart: action.part
      };
    }
    case DocumentAnalysisActionTypes.GetImageURLSuccess: {
      return {
        ...state,
        imageURL: action.url
      };
    }
    /*case DocumentAnalysisActionTypes.SelectPage: {
      return {
        ...state,
        selectedPage: action.page
      };
    }
    case DocumentAnalysisActionTypes.SelectRegion: {
      return {
        ...state,
        selectedRegion: action.region
      };
    }*/
    case DocumentAnalysisActionTypes.ChangePageBoundingBoxSuccess: {
      const newState = {...state};

      newState.pages = deepcopy<Page[]>(state.pages);

      const page = newState.pages.find(p => p.id === action.page.id);
      if (page) {
        page.boundingBox = action.page.boundingBox;
      }
      return newState;
    }
    case DocumentAnalysisActionTypes.ChangeRegionTypeSuccess: {
      const newState = {...state};

      newState.pages = deepcopy<Page[]>(state.pages);

      newState.pages.forEach(page => {
          const region = page.regions.find(r => r.id === action.region.id);
          if (region) {
            region.regionType = action.region.regionType;
            return;
          }
        }
      );
      return newState;
    }
    case DocumentAnalysisActionTypes.ChangeRegionBoundingBoxSuccess: {
      const newState = {...state};

      newState.pages = deepcopy<Page[]>(state.pages);

      newState.pages.forEach(page => {
          const region = page.regions.find(r => r.id === action.region.id);
          if (region) {
            region.boundingBox = action.region.boundingBox;
            return;
          }
        }
      );
      return newState;
    }
    case DocumentAnalysisActionTypes.ClearSuccess: {
      const newState = {...state};
      newState.pages = action.pages;
      return newState;
    }
    case DocumentAnalysisActionTypes.CreatePageSuccess: {
      const newState = {...state};
      if (action.pages == null) { // if an error has ocurred
        newState.pages = deepcopy<Page[]>(state.pages);
      } else {
        newState.pages = deepcopy<Page[]>(action.pages);
      }

      return newState;
    }
    case DocumentAnalysisActionTypes.CreateRegionSuccess: {
      const newState = {...state};
      if (action.pages == null) { // if an error has ocurred
        newState.pages = deepcopy<Page[]>(state.pages);
      } else {
        newState.pages = deepcopy<Page[]>(action.pages);
      }
      return newState;
    }
    case DocumentAnalysisActionTypes.DeletePageSuccess: {
      const newState = {...state};
      newState.pages = deepcopy<Page[]>(state.pages);

      if (action.deletedPageID) { // if no error has ocurred
        // remove the deleted page
        if (newState.pages) { // we may have deleted all pages
          newState.pages = newState.pages.filter(page => page.id !== action.deletedPageID);
        }
      }
      return newState;
    }
    case DocumentAnalysisActionTypes.DeleteRegionSuccess: {
      const newState = {...state};
      newState.pages = deepcopy<Page[]>(state.pages);

      if (action.deletedRegionID) { // if no error has ocurred
        // remove the deleted region
        newState.pages.forEach(page => {
          page.regions = page.regions.filter(region => region.id !== action.deletedRegionID);
        });
      }
      return newState;
    }
    default: {
      return state;
    }
  }
}
