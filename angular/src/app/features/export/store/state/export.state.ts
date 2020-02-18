import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface ExportState {
  trainingSetExporters: TrainingSetExporter[];
  trainingSetExportedBlob: Blob;
  apiRestServerError: APIRestServerError;
}

export const initialExportState: ExportState = {
  trainingSetExporters: null,
  trainingSetExportedBlob: null,
  apiRestServerError: null
};
