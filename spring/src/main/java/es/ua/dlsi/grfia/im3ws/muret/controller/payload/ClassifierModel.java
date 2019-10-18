package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class ClassifierModel {
    String id;
    String last_train;
    String name;
    String vocabulary;
    String classifier_type;

    public ClassifierModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast_train() {
        return last_train;
    }

    public void setLast_train(String last_train) {
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

    public String getClassifier_type() {
        return classifier_type;
    }

    public void setClassifier_type(String classifier_type) {
        this.classifier_type = classifier_type;
    }
}
