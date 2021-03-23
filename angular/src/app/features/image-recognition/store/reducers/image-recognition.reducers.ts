// recall the inmutability of state
import {ImageRecognitionActions, ImageRecognitionActionTypes} from "../actions/image-recognition.actions";
import {klona} from "klona";
import {ImageRecognitionState, initialImageRecognitionState} from "../state/image-recognition.state";
import {SemanticRepresentationActionTypes} from "../../../semantic-representation-old/store/actions/semantic-representation.actions";

/**
 * We use the same effects, actions and reducers for overview and parts because they share the state
 */
export function imageRecognitionReducers(state = initialImageRecognitionState, action: ImageRecognitionActions): ImageRecognitionState {
  switch (action.type) {
    /*case ImageRecognitionActionTypes.ImageRecognitionServerError: {
      return {
        ...state,
        analyzing: false,
        //apiRestServerError: action.serverError
      };
    }*/
    case ImageRecognitionActionTypes.ImageRecognitionGetImageOverviewSuccess: {
      return {
        ...state,
        imageOverview: action.imageOverview,
        //apiRestServerError: null
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbolsSuccess: {
      return {
        ...state,
        pagesRegionsSymbols: action.pagesRegionsSymbols,
        //apiRestServerError: null
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionPutCommentsSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      newState.imageOverview.comments = action.comments;
      return newState;
    }

    case ImageRecognitionActionTypes.ImageRecognitionChangeStatusSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      newState.imageOverview.imageRecognitionProgressStatuses = action.statuses;
      return newState;
    }


    /// ----- Parts ----
    case ImageRecognitionActionTypes.ImageRecognitionLinkPartSuccess:
    case ImageRecognitionActionTypes.ImageRecognitionUnlinkPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: action.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionLinkNewPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: action.pagesRegionsSymbolsAndNewPart.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      newState.imageOverview.documentParts.push(action.pagesRegionsSymbolsAndNewPart.part);
      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionLinkImageToPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      newState.imageOverview.imagePart = action.part;
      return newState;
      break;
    }
    case ImageRecognitionActionTypes.ImageRecognitionLinkImageToNewPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      newState.imageOverview.imagePart = action.part;
      newState.imageOverview.documentParts.push(action.part);
      return newState;
      break;
    }
    case ImageRecognitionActionTypes.ImageRecognitionUnlinkImageFromPartSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: state.pagesRegionsSymbols,
        imageOverview: klona(state.imageOverview),
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      newState.imageOverview.imagePart = null;
      return newState;
    }

    /// ------ Document analysis
    case ImageRecognitionActionTypes.ImageRecognitionGetRegionTypesSuccess: {
      return {
        ...state,
        regionTypes: action.regionTypes,
        //apiRestServerError: null
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionChangeRegionsTypeSuccess: {
      const regionType = state.regionTypes.find(regionType => regionType.id === action.changeRegionTypes.regionTypeID);
      if (!regionType) {
        throw new Error('Cannot find region type with id "' + action.changeRegionTypes.regionTypeID + '"');
        return {
          ...state,
          //apiRestServerError: createServerError('Region types change', 'Cannot find region type with id ' + action.changeRegionTypes.regionTypeID)
        };
      }

      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      const changedRegionTypesSet = new Set<number>();
      action.changeRegionTypes.regionIDs.values.forEach(id => changedRegionTypesSet.add(id));
      newState.pagesRegionsSymbols.forEach(page => {
        page.regions.forEach(region => {
          if (changedRegionTypesSet.has(region.id)) {
            region.regionType = regionType;
          }
        });
      });
      return newState;
    }

    case ImageRecognitionActionTypes.ImageRecognitionClearSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: [],
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionDeletePagesSuccess: {
      const deletedPageIDS = new Set<number>();
      action.deletedPageIDs.values.forEach(id => deletedPageIDS.add(id));

      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols.filter(page => !deletedPageIDS.has(page.id))),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      return newState;
    }

    case ImageRecognitionActionTypes.ImageRecognitionCreatePagesSuccess: // the action returns a new whole set of page, regions...
    case ImageRecognitionActionTypes.ImageRecognitionCreatePageSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: action.pages,
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionDeleteRegionsSuccess: {
      const deletedRegionIDS = new Set<number>();
      action.deletedRegionIDs.values.forEach(id => deletedRegionIDS.add(id));
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };

      newState.pagesRegionsSymbols.forEach(page => {
        page.regions = klona(page.regions.filter(region => !deletedRegionIDS.has(region.id)))
      });
      return newState;

    }
    case ImageRecognitionActionTypes.ImageRecognitionCreateRegionSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: action.pages,
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: state.analyzing,
        //apiRestServerError: null
      };
      return newState;
      /*const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        //apiRestServerError: null
      };
      action.pages.forEach(page => {
        const changedPage = newState.pagesRegionsSymbols.find(p => p.id === page.id);
        debugger;
        if (!changedPage) {
          return {
            pagesRegionsSymbols: state.pagesRegionsSymbols,
            imageOverview: state.imageOverview,
            regionTypes: state.regionTypes,
            //apiRestServerError: createServerError('Cannot add region', 'Cannot find page with id=' + page.id)
          }
        } else {
          page.regions.forEach(region => {
            changedPage.regions.push(region);
          });
        }
      });
      return newState;*/
    }
    case ImageRecognitionActionTypes.ImageRecognitionGetClassifierModelsSuccess: {
      return {
        ...state,
        classifierModels: action.response
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionAutomaticDocumentAnalysis: {
      return {
        ...state,
        analyzing: true
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionAutomaticDocumentAnalysisSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: action.pages,
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: false,
        //apiRestServerError: null
      };
      return newState;
    }

    /// ---------- agnostic recognition
    case ImageRecognitionActionTypes.ImageRecognitionSelectRegion: {
      return {
        ...state,
        notation: null,
        selectedRegion: action.region
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionSelectAgnosticSymbols: {
      return {
        ...state,
        selectedAgnosticSymbols: action.agnosticSymbols
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionCreateSymbolFromBoundingBox:
    case ImageRecognitionActionTypes.ImageRecognitionCreateSymbolFromStrokes: {
      return {
        ...state,
        analyzing: true
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionCreateSymbolSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: false,
        //apiRestServerError: null
      };

      const page = newState.pagesRegionsSymbols.find(page => page.id == action.symbolCreationResult.pageID);
      if (!page) {
        throw new Error('Cannot find page ID = ' + action.symbolCreationResult.pageID);
      }

      const region = page.regions.find(region => region.id == action.symbolCreationResult.regionID);
      if (!region) {
        throw new Error('Cannot find region ID = ' + action.symbolCreationResult.regionID);
      }

      if (!region.symbols) {
        region.symbols = [];
      }

      region.symbols.push(action.symbolCreationResult.agnosticSymbol);
      newState.selectedRegion = region;
      //TODO Coger también los símbolos clasificados para sacar la lista de mejores resultados en la GUI
      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionDeleteSymbolsSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: false,
        //apiRestServerError: null
      };

      const deletedSymbols: Set<Number> = new Set<Number>();
      action.deletedAgnosticSymbolIDs.values.forEach(n => deletedSymbols.add(n));
      newState.pagesRegionsSymbols.forEach(page => {
        page.regions.forEach(region => {
          if  (region.id === state.selectedRegion.id) {
            region.symbols = region.symbols.filter(symbol => !deletedSymbols.has(symbol.id));
            newState.selectedRegion = region;
          }
        });
      });

      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionClearRegionSymbolsSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: false,
        //apiRestServerError: null
      };

      newState.pagesRegionsSymbols.forEach(page => {
        page.regions.forEach(region => {
          if  (region.id === state.selectedRegion.id) {
            region.symbols = [];
            newState.selectedRegion = region;
          }
        });
      });

      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionClassifyRegionEndToEnd: {
      return {
        ...state,
        analyzing: true
      };
    }
    case ImageRecognitionActionTypes.ImageRecognitionClassifyRegionEndToEndSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: false,
        //apiRestServerError: null
      };

      newState.pagesRegionsSymbols.forEach(page => {
        page.regions.forEach(region => {
          if  (region.id === state.selectedRegion.id) {
            region.symbols = action.classifiedSymbols;
            newState.selectedRegion = region;
          }
        });
      });

      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionChangeSymbolSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: false,
        //apiRestServerError: null
      };

      newState.pagesRegionsSymbols.forEach(page => {
        page.regions.forEach(region => {
          if  (region.id === state.selectedRegion.id) {
            const index = region.symbols.findIndex(s => s.id === action.agnosticSymbol.id);
            if (index == -1) {
              throw new Error('Cannot find agnostic symbol with id = ' + action.agnosticSymbol.id);
            }
            region.symbols[index] = action.agnosticSymbol;
            newState.selectedRegion = region;
            newState.selectedAgnosticSymbols = [action.agnosticSymbol];
          }
        });
      });

      return newState;
    }
    // ---- semantic
    case ImageRecognitionActionTypes.ImageRecognitionConvertAgnostic2SemanticSuccess:
    case ImageRecognitionActionTypes.ImageRecognitionGetNotationSuccess:
    case ImageRecognitionActionTypes.ImageRecognitionSendSemanticEncodingSuccess: {
      const newState = {
        //apiRestServerError: null,
        ...state
      };
      newState.notation = action.notation; // the notation contains the selected region semantic encoding - we don't use the one in the region
      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionChangeNotationTypeSuccess: {
      const newState: ImageRecognitionState = {
        pagesRegionsSymbols: klona(state.pagesRegionsSymbols),
        imageOverview: state.imageOverview,
        regionTypes: state.regionTypes,
        classifierModels: state.classifierModels,
        analyzing: false,
        //apiRestServerError: null
      };

      newState.pagesRegionsSymbols.forEach(page => {
        page.regions.forEach(region => {
          if (region.id === action.region.id) {
            region.notationType = action.region.notationType;
            newState.selectedRegion = region;
          }
        })});
      return newState;
    }
    case ImageRecognitionActionTypes.ImageRecognitionSelectNotationSymbol: {
      return {
        ...state,
        selectedNotationSymbolID: action.notationSymbolID
      };
    }

    default:
      return state;
  }

}
