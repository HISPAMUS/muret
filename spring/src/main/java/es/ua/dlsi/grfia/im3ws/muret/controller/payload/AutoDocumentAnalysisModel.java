package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.List;

public class AutoDocumentAnalysisModel {
    List<CoordinatesDocAnBounding> regions;

    public AutoDocumentAnalysisModel(){}
    public AutoDocumentAnalysisModel(List<CoordinatesDocAnBounding> staff)
    {
        this.regions = staff;
    }

    public List<CoordinatesDocAnBounding> getRegions() {
        return regions;
    }

    public void setRegions(List<CoordinatesDocAnBounding> regions) {
        this.regions = regions;
    }
}
