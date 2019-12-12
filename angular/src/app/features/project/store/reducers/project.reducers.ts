import {ProjectActions, ProjectActionTypes} from '../actions/project.actions';
import {initialProjectState, ProjectState} from '../state/project.state';
import { saveAs } from 'file-saver';

export function projectReducers(state = initialProjectState, action: ProjectActions): ProjectState {
  switch (action.type) {
    case ProjectActionTypes.GetProjectSuccess: {
      return {
        ...state,
        project: action.project
      };
    }
    case ProjectActionTypes.GetImagesSuccess: {
      return {
        ...state,
        images: action.images
      };
    }
    case ProjectActionTypes.ExportMEI: {
      return {
        ...state,
        mei: null
      };
    }
    case ProjectActionTypes.ExportMEISuccess: {
      return {
        ...state,
        mei: action.mei
      };
    }
    case ProjectActionTypes.ExportMEIPartsFacsimileSuccess: {
      const blob = new Blob([action.mei], { type: 'text/plain' });
      saveAs(blob, 'parts_facsimile.mei');
      return {...state};
    }
    case ProjectActionTypes.ExportMensurstrichSuccess: {
      const blob = new Blob([action.payload], { type: 'application/x-gzip' });
      saveAs(blob, 'mensurstrich.tgz');
      return {...state};
    }
    case ProjectActionTypes.ExportMusicXMLSuccess: {
      const blob = new Blob([action.payload], { type: 'application/x-gzip' });
      saveAs(blob, 'musicxml.tgz');
      return {...state};
    }
    case ProjectActionTypes.GetProjectStatisticsSuccess: {
      return {
        ...state,
        statistics: action.projectStatistics
      };
    }
    default: {
      return state;
    }
  }
}
