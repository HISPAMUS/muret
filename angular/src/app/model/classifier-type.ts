import {Classifier} from './classifier';

export class ClassifierType {
  id: number;
  name: string;
  classifiers: Array<Classifier>;


  constructor(id: number, name: string, classifiers: Array<Classifier>) {
    this.id = id;
    this.name = name;
    this.classifiers = classifiers;
  }
}
