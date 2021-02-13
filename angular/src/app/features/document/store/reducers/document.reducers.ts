import {DocumentActions, DocumentActionTypes} from '../actions/document.actions';
import {DocumentState, initialDocumentState} from '../state/document.state';
import {DocumentExportType} from '../../../../core/model/restapi/document-export';
import {Section} from "../../../../core/model/entities/section";
import {APIRestServerError} from "../../../../core/model/restapi/apirest-server-error";
import {Image} from "../../../../core/model/entities/image";
import { klona } from 'klona/lite';


export function documentReducers(state = initialDocumentState, action: DocumentActions): DocumentState {
  switch (action.type) {
    case DocumentActionTypes.DocumentGetOverviewSuccess: {
      return {
        ...state,
        documentOverview: action.documentOverview,
        apiRestServerError: null
      };
    }

    case DocumentActionTypes.DocumentServerError: {
      return {
        ...state,
        apiRestServerError: action.error
      };
    }

    case DocumentActionTypes.DocumentMoveImagesToSectionSuccess: {
      const newState = klona(state); // deep copy
      newState.apiRestServerError = null;

      let newSection: Section;
      if (action.sectionImages.newSectionID) {
        newSection = findSection(newState.documentOverview.sections, action.sectionImages.newSectionID);
        if (!newSection) {
          newState.apiRestServerError = createServerError('Cannot move image to section', 'Cannot find new section with id ' + action.sectionImages.newSectionID);
        }
      } else {
        newSection = null;
      }

      if (action.sectionImages.imageIDS.length !== action.sectionImages.previousSectionIDs.length) {
        newState.apiRestServerError = createServerError('Cannot move image to section', 'The image IDS != previous section IDs');
      }
      for (let i=0; i<action.sectionImages.imageIDS.length; i++) {
        const imageID = action.sectionImages.imageIDS[i];
        const previousSectionID = action.sectionImages.previousSectionIDs[i];

        let previousSection: Section;
        let changedImage: Image;
        if (previousSectionID) { // if it was in a section
          const previousSection = findSection(newState.documentOverview.sections, previousSectionID);
          if (!previousSection) {
            newState.apiRestServerError = createServerError('Cannot move image to section', 'Cannot find previous section with id ' + previousSectionID);
          }
          changedImage = previousSection.images.find(image => image.id === imageID);
          // remove from previous section (if there was one)
          previousSection.images = previousSection.images.filter(image => image.id !== imageID);
        } else {
          previousSection = null;
          changedImage = newState.documentOverview.images.find(image => image.id === imageID);
          // remove from unassigned (document) (if there was one)
          newState.documentOverview.images = newState.documentOverview.images.filter(image => image.id !== imageID);
        }

        if (!changedImage) {
          newState.apiRestServerError = createServerError('Cannot move image to section', 'Cannot find image with id ' + imageID);
        } else {
          if (newSection) {
            changedImage.sectionId = newSection.id;
            // add to new section
            newSection.images.push(changedImage);
          } else {
            changedImage.sectionId = null;
            // add to unassigned (document images)
            newState.documentOverview.images.push(changedImage);
          }
        }
      }
      return newState;
    }

    // revisado hasta aquí
    case DocumentActionTypes.ResetDocumentServerError: {
      return {
        ...state,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentGetDocumentSuccess: {
      return {
        ...state,
        document: action.document,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentGetImagesSuccess: {
      return {
        ...state,
        images: action.images,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMusicXML:
    case DocumentActionTypes.DocumentExportMensurstrich:
    case DocumentActionTypes.DocumentExportMEI: {
      return {
        ...state,
        exportedFile: null,
        mei: null,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMEIPartsFacsimileSuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.mei_parts_facsimile,
          file: action.mei != null ? new Blob([action.mei], {type: 'text/plain'}) : null,
          fileExtension: 'mei',
        },
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMEISuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.mei_score,
          file: action.mei != null ? new Blob([action.mei], {type: 'text/plain'}) : null,
          fileExtension: 'mei',
        },
        mei: action.mei,
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMusicXMLSuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.musicxml,
          file: action.payload != null ? new Blob([action.payload], {type: 'application/x-gzip'}) : null,
          fileExtension: 'tgz',
        },
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMensurstrichSuccess: {
      return {
        ...state,
        exportedFile: {
          type: DocumentExportType.mensurstrich_svg,
          file: action.payload = new Blob([action.payload], {type: 'application/x-gzip'}),
          fileExtension: 'tgz',
        },
        apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentGetDocumentStatisticsSuccess: {
      return {
        ...state,
        statistics: action.documentStatistics,
        apiRestServerError: null
      };
    }
    /*case DocumentActionTypes.PreflightCheckSuccess: {
      return {
        ...state,
        preflightCheckResults: action.preflightCheckResult
      };
    }*/
    case DocumentActionTypes.DocumentGetAlignmentPreviewSuccess: {
      return {
        ...state,
        alignmentPreview: action.alignmentPreview,
        apiRestServerError: null
      };
    }
    default: {
      return state;
    }
  }
}

function findSection(sections: Section[], sectionID: number): Section {
  return sections.find(section => section.id === sectionID);
}

function createServerError(message: string, detailedMessage: string): APIRestServerError {
  const result: APIRestServerError = {
    message: message,
      detailedMessage: detailedMessage
  };
  return result;
}

