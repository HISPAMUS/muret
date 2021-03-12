export interface ClassifierModel {
  id: string;
  last_train: string; // use this variable name - it comes from Python server through the Spring server
  name: string;
  classifier_type: string; // see ClassifierModelTypes
  vocabulary: string; //TODO????
}
