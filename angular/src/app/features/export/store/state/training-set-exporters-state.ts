import {TrainingSetExporter} from '../../../../core/model/restapi/training-set-exporter';

export interface TrainingSetExportersState {
  trainingSetExporters: TrainingSetExporter[];
}

export const initialTrainingSetExportersState: TrainingSetExportersState = {
  trainingSetExporters: null
};
