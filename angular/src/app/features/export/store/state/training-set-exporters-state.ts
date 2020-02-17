import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export interface TrainingSetExportersState {
  trainingSetExporters: TrainingSetExporter[];
  apiRestServerError: APIRestServerError;
}

export const initialTrainingSetExportersState: TrainingSetExportersState = {
  trainingSetExporters: null,
  apiRestServerError: null
};
