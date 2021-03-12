package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.Date;

public class ClassifierModel {
    String id;
    Date last_train; // keep this name because it's obtained from the python server
    String name;
    String vocabulary; //TODO ???
    ClassifierModelTypes classifier_type; // keep this name because it's obtained from the python server

    public ClassifierModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLast_train() {
        return last_train;
    }

    public void setLast_train(Date last_train) {
        this.last_train = last_train;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public ClassifierModelTypes getClassifier_type() {
        return classifier_type;
    }

    public void setClassifier_type(ClassifierModelTypes classifier_type) {
        this.classifier_type = classifier_type;
    }
}
