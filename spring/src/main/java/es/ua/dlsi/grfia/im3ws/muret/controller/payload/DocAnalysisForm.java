package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import javax.validation.constraints.NotBlank;

public class DocAnalysisForm
{
    @NotBlank
    private int imageID;
    @NotBlank
    private String modelToUse;
    @NotBlank
    private int numPages;

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

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}
