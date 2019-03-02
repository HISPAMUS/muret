import {TrainingSetExporter} from '../../../../core/model/entities/training-set-exporter';

export interface TrainingSetExportersState {
  trainingSetExporters: TrainingSetExporter[];
}

export const initialTrainingSetExportersState: TrainingSetExportersState = {
  trainingSetExporters: null
};
