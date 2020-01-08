package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import javax.validation.constraints.NotBlank;

public class DocAnalysisForm
{
    @NotBlank
    private int imageID;
    @NotBlank
    private String modelToUse;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getModelToUse() {
        return modelToUse;
    }

    public void setModelToUse(String modelToUse) {
        this.modelToUse = modelToUse;
    }
}
