import {DocumentAnalysisState, initialDocumentAnalysisState} from '../state/document-analysis.state';
import {DocumentAnalysisActions, DocumentAnalysisActionTypes} from '../actions/document-analysis.actions';
import {Page} from '../../../../core/model/entities/page';
import deepcopy from 'ts-deepcopy';

export function documentAnalysisReducers(state = initialDocumentAnalysisState, action: DocumentAnalysisActions): DocumentAnalysisState {
  switch (action.type) {
    case DocumentAnalysisActionTypes.ResetDocumentAnalysisServerError:
      return {
        ...state,
        apiRestServerError: null
      };
    case DocumentAnalysisActionTypes.DocumentAnalysisServerError:
      return {
        ...state,
        apiRestServerError: action.serverError
      };
    case DocumentAnalysisActionTypes.GetRegionTypesSuccess: {
      return {
        ...state,
        regionTypes: action.regionTypes,
        apiRestServerError: null
      };
    }
    case DocumentAnalysisActionTypes.GetImageProjection: { // reset before downloading new elements
      return {
        ...initialDocumentAnalysisState,
        apiRestServerError: null
      };
    }
    case DocumentAnalysisActionTypes.GetImageProjectionSuccess: {
      return {
        ...state,
        documentID: action.documentAnalysisImageProjection.documentId,
        imageWidth: action.documentAnalysisImageProjection.width,
        imageHeight: action.documentAnalysisImageProjection.height,
        filename: action.documentAnalysisImageProjection.filename,
        pages: action.documentAnalysisImageProjection.pages,
        imagePart: action.documentAnalysisImageProjection.part,
        documentType: {
          manuscriptType: action.documentAnalysisImageProjection.manuscriptType,
          notationType: action.documentAnalysisImageProjection.notationType
        },
        apiRestServerError: null
      };
    }
    case DocumentAnalysisActionTypes.GetImagePartSuccess: {
      return {
        ...state,
        imagePart: action.part,
        apiRestServerError: null
      };
    }
    case DocumentAnalysisActionTypes.GetImageURLSuccess: {
      return {
        ...state,
        imageURL: action.url,
        apiRestServerError: null
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
      const newState = {...state,
        apiRestServerError: null};

      newState.pages = deepcopy<Page[]>(state.pages);

      const page = newState.pages.find(p => p.id === action.page.id);
      if (page) {
        page.boundingBox = action.page.boundingBox;
      }
      return newState;
    }
    case DocumentAnalysisActionTypes.ChangeRegionTypeSuccess: {
      const newState = {...state,
        apiRestServerError: null};

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
      const newState = {...state,
        apiRestServerError: null};

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
      const newState = {...state,
        apiRestServerError: null};
      newState.pages = [];
      return newState;
    }
    case DocumentAnalysisActionTypes.CreatePagesSuccess:
    case DocumentAnalysisActionTypes.CreatePageSuccess: {
      const newState = {...state};
      if (action.pages == null) { // if an error has occurred
        newState.pages = deepcopy<Page[]>(state.pages);
      } else {
        newState.pages = deepcopy<Page[]>(action.pages);
      }

      return newState;
    }
    case DocumentAnalysisActionTypes.CreateRegionSuccess: {
      const newState = {...state,
        apiRestServerError: null};
      if (action.pages == null) { // if an error has ocurred
        newState.pages = deepcopy<Page[]>(state.pages);
      } else {
        newState.pages = deepcopy<Page[]>(action.pages);
      }
      return newState;
    }
    case DocumentAnalysisActionTypes.DeletePageSuccess: {
      const newState = {...state,
        apiRestServerError: null};
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
      const newState = {...state,
        apiRestServerError: null};
      newState.pages = deepcopy<Page[]>(state.pages);

      if (action.deletedRegionID) { // if no error has ocurred
        // remove the deleted region
        newState.pages.forEach(page => {
          page.regions = page.regions.filter(region => region.id !== action.deletedRegionID);
        });
      }
      return newState;
    }
    case DocumentAnalysisActionTypes.GetDocumentAnModels : {
      return {...state,
      documentAnalysisClassifierModels: null,
        apiRestServerError: null};
    }
    case DocumentAnalysisActionTypes.GetDocumentAnModelsSuccess: {
      return {...state,
      documentAnalysisClassifierModels: action.response,
        apiRestServerError: null};
    }

    case DocumentAnalysisActionTypes.AutomaticDocumentAnalysisSuccess: {
      const newState = {...state,
        apiRestServerError: null};
      newState.pages = deepcopy<Page[]>(action.pages);
      return newState;
    }

    default: {
      return state;
    }
  }
}
