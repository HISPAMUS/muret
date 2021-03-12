export interface ClassifierModel {
  id: string;
  last_train: Date; // use this variable name - it comes from Python server through the Spring servierz
  name: string;
  classifier_type: string; // see ClassifierModelTypes
  vocabulary: string; //TODO????
}
