package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.List;

public class AutoDocumentAnalysisModel {
    List<CoordinatesDocAnBounding> staff;

    public AutoDocumentAnalysisModel(){}
    public AutoDocumentAnalysisModel(List<CoordinatesDocAnBounding> staff)
    {
        this.staff = staff;
    }

    public List<CoordinatesDocAnBounding> getStaff() {
        return staff;
    }

    public void setStaff(List<CoordinatesDocAnBounding> staff) {
        this.staff = staff;
    }
}
