import {DocumentActions, DocumentActionTypes} from '../actions/document.actions';
import {DocumentState, initialDocumentState} from '../state/document.state';
import {DocumentExportType} from '../../../../core/model/restapi/document-export';
import {Section} from "../../../../core/model/entities/section";
//import {//apiRestServerError, createServerError} from "../../../../core/model/restapi/apirest-server-error";
import {Image} from "../../../../core/model/entities/image";
import { klona } from 'klona/lite';


export function documentReducers(state = initialDocumentState, action: DocumentActions): DocumentState {
  switch (action.type) {
    case DocumentActionTypes.DocumentGetOverviewSuccess: {
      const documentOverview = klona(action.documentOverview); // deep copy
      return {
        ...state,
        documentOverview: documentOverview,
        //apiRestServerError: null
      };
    }

    case DocumentActionTypes.DocumentServerError: {
      return {
        ...state,
        //apiRestServerError: action.error
      };
    }

    case DocumentActionTypes.DocumentMoveImagesToDefaultSectionSuccess: {
      const newState = klona(state); // deep copy
      //newState.//apiRestServerError = null;
      newState.documentOverview.sections = [klona(action.section)];
      newState.documentOverview.sections[0].images = newState.documentOverview.images;
      newState.documentOverview.images = [];
      return newState;
      break;
    }
    case DocumentActionTypes.DocumentMoveImagesToSectionSuccess: {
      const newState = klona(state); // deep copy
      //newState.//apiRestServerError = null;

      let newSection: Section;
      if (action.sectionImages.newSectionID) {
        newSection = findSection(newState.documentOverview.sections, action.sectionImages.newSectionID);
        if (!newSection) {
          throw new Error('Cannot find new section with id ' + action.sectionImages.newSectionID);
        }
          //newState.//apiRestServerError = createServerError('Cannot update movement image to section', 'Cannot find new section with id ' + action.sectionImages.newSectionID);
      } else {
        newSection = null;
      }

      if (action.sectionImages.imageIDS.length !== action.sectionImages.previousSectionIDs.length) {
        //newState.//apiRestServerError = createServerError('Cannot update movement image to section', 'The image IDS != previous section IDs');
        throw new Error('The image IDS != previous section IDs');
      }
      for (let i=0; i<action.sectionImages.imageIDS.length; i++) {
        const imageID = action.sectionImages.imageIDS[i];
        const previousSectionID = action.sectionImages.previousSectionIDs[i];

        let previousSection: Section;
        let changedImage: Image;
        if (previousSectionID) { // if it was in a section
          const previousSection = findSection(newState.documentOverview.sections, previousSectionID);
          if (!previousSection) {
            //newState.//apiRestServerError = createServerError('Cannot update movement image to section', 'Cannot find previous section with id ' + previousSectionID);
            throw new Error('Cannot find previous section with id ' + previousSectionID);
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
          //newState.//apiRestServerError = createServerError('Cannot update movement image to section', 'Cannot find image with id ' + imageID);
          throw new Error('Cannot find image with id ' + imageID);
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

    case DocumentActionTypes.DocumentCreateSectionSuccess: {
      const newState = klona(state); // deep copy
      //newState.//apiRestServerError = null;
      const newSection = klona(action.section);
      newSection.images = [];// if comes with null value
      newState.documentOverview.sections.push(newSection);
      return newState;
    }

    case DocumentActionTypes.DocumentRenameSectionSuccess: {
      const newState = klona(state); // deep copy
      //newState.//apiRestServerError = null;
      const changedSection = newState.documentOverview.sections.find(section => section.id === action.section.id);
      if (!changedSection) {
        //newState.//apiRestServerError = createServerError('Cannot update renamed section', 'Cannot find section with id ' + action.section.id);
        throw new Error('Cannot find section with id ' + action.section.id);
      } else {
        changedSection.name = action.section.name;
      }
      return newState;
    }

    case DocumentActionTypes.DocumentDeleteSectionSuccess: {
      const newState = klona(state); // deep copy
      //newState.//apiRestServerError = null;
      const deletedSection = newState.documentOverview.sections.find(section => section.id === action.sectionID);
      if (!deletedSection) {
        //newState.//apiRestServerError = createServerError('Cannot update deleted section', 'Cannot find section with id ' + action.sectionID);
        throw new Error('Cannot find section with id ' + action.sectionID);
      } else {
        // move all the images to the document
        newState.documentOverview.images = newState.documentOverview.images.concat(deletedSection.images);
        newState.documentOverview.sections = newState.documentOverview.sections.filter(section => section.id !== action.sectionID);
      }
      return newState;
    }

    case DocumentActionTypes.DocumentReorderSectionsSuccess: {
      const newState = klona(state); // deep copy
      //newState.//apiRestServerError = null;
      const sectionMap: Map<number, Section> = new Map<number, Section>();
      newState.documentOverview.sections.forEach(section => {
        sectionMap.set(section.id, section);
      })
      // now insert ordered
      newState.documentOverview.sections = new Array();

      let i=0;
      action.ordering.values.forEach(id => {
        const section = sectionMap.get(id);
        if (!section) {
          //newState.//apiRestServerError = createServerError('Cannot update sections after reordering', 'Cannot find new section with id ' + id);
          throw new Error('Cannot find new section with id ' + id);
        } else {
          section.ordering = i;
          newState.documentOverview.sections.push(section);
          i++;
        }
      });

      return newState;
    }
    case DocumentActionTypes.DocumentGetSectionSuccess: {
      const result: DocumentState = {
        ...state,
        //apiRestServerError: null
      };
      result.section = action.section;
      return result;
    }
    case DocumentActionTypes.DocumentReorderImagesSuccess: {
      const newState: DocumentState = klona(state);
      //newState.//apiRestServerError = null;
      const imageMap: Map<number, Image> = new Map<number, Image>();

      newState.section.images.forEach(image => {
        imageMap.set(image.id, image);
      });
      let i=0;
      newState.section.images = [];
      action.ordering.values.forEach(id => {
        const image = imageMap.get(id);
        if (!image) {
          //newState.//apiRestServerError = createServerError('Cannot update images after reordering', 'Cannot find new image with id ' + id);
          throw new Error('Cannot find new image with id ' + id);
        } else {
          image.ordering = i;
          newState.section.images.push(image);
          i++;
        }
      });

      return newState;
    }
    case DocumentActionTypes.DocumentLinkImagesToNewPartSuccess: {
      const newState: DocumentState = klona(state);
      //newState.//apiRestServerError = null;
      newState.documentOverview.parts.push(action.imagesInNewPart.part);
      newState.partsInImages = action.imagesInNewPart.partsInImage;
      return newState;
    }
    case DocumentActionTypes.DocumentGetPartsInImagesSuccess:
    case DocumentActionTypes.DocumentUnlinkImagesFromPartSuccess:
    case DocumentActionTypes.DocumentLinkImagesToPartSuccess: {
      const result: DocumentState = {
        ...state,
        //apiRestServerError: null
      };
      result.partsInImages = action.partsInImages;
      return result;
    }
    case DocumentActionTypes.DocumentChangeImagesVisibilitySuccess: {
      const result: DocumentState = {
        documentOverview: klona(state.documentOverview),
        section: state.section,
        partsInImages: state.partsInImages,
        //apiRestServerError: null
      };
      const changedImageIDS: Set<number> = new Set<number>();
      action.imagesVisibility.imageIDS.values.forEach(id => {
        changedImageIDS.add(id);
      });
      result.documentOverview.images.forEach(image => {
        if (changedImageIDS.has(image.id)) {
          image.hidden = action.imagesVisibility.hidden
        }
      });
      result.documentOverview.sections.forEach(section => {
        section.images.forEach(image => {
          if (changedImageIDS.has(image.id)) {
            image.hidden = action.imagesVisibility.hidden
          }
        });
      });
      return result;
    }
    case DocumentActionTypes.DocumentExportMEIPartsFacsimile:
    case DocumentActionTypes.DocumentExportMusicXML:
    case DocumentActionTypes.DocumentExportMensurstrich:
    case DocumentActionTypes.DocumentExportMEI: {
      return {
        ...state,
        exportedMEIFile: null,
        mei: null,
        //apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMEIPartsFacsimileSuccess: {
      return {
        ...state,
        exportedMPEditorFile: {
          type: DocumentExportType.mei_parts_facsimile,
          file: action.mei != null ? new Blob([action.mei], {type: 'text/plain'}) : null,
          fileExtension: 'mei',
        },
        //apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMEISuccess: {
      return {
        ...state,
        exportedMEIFile: {
          type: DocumentExportType.mei_score,
          file: action.mei != null ? new Blob([action.mei], {type: 'text/plain'}) : null,
          fileExtension: 'mei',
        },
        mei: action.mei,
        //apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentGetDocumentStatistics: {
      return {
        ...state,
        statistics: null,
        //apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentGetDocumentStatisticsSuccess: {
      return {
        ...state,
        statistics: action.documentStatistics,
        //apiRestServerError: null
      };
    }

    /*case DocumentActionTypes.DocumentSelectImagesForExport: {
      return {
        ...state,
        selectedImagesIDForExport: action.imagesID
      };
    }*/

    // revisado hasta aquí
    case DocumentActionTypes.ResetDocumentServerError: {
      return {
        ...state,
        //apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentGetDocumentSuccess: {
      return {
        ...state,
        document: action.document,
        //apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentGetImagesSuccess: {
      return {
        ...state,
        images: action.images,
        //apiRestServerError: null
      };
    }

    case DocumentActionTypes.DocumentExportMusicXMLSuccess: {
      return {
        ...state,
        exportedMEIFile: {
          type: DocumentExportType.musicxml,
          file: action.payload != null ? new Blob([action.payload], {type: 'application/x-gzip'}) : null,
          fileExtension: 'tgz',
        },
        //apiRestServerError: null
      };
    }
    case DocumentActionTypes.DocumentExportMensurstrichSuccess: {
      return {
        ...state,
        exportedMEIFile: {
          type: DocumentExportType.mensurstrich_svg,
          file: action.payload = new Blob([action.payload], {type: 'application/x-gzip'}),
          fileExtension: 'tgz',
        },
        //apiRestServerError: null
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
        //apiRestServerError: null
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

