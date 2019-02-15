import {Classifier} from './classifier';

export interface ClassifierType {
  id: number;
  name: string;
  classifiers: Classifier[];
}
