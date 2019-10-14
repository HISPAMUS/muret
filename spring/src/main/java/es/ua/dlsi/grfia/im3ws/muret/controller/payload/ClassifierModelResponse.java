package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.List;

public class ClassifierModelResponse {
    List<ClassifierModel> message;

    public ClassifierModelResponse() {
    }

    public ClassifierModelResponse(List<ClassifierModel> message) {
        this.message = message;
    }

    public List<ClassifierModel> getMessage() {
        return message;
    }

    public void setMessage(List<ClassifierModel> message) {
        this.message = message;
    }
}
