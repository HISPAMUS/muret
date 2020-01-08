package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.List;

public class AutoDocumentAnalysisModel
{
    List<CoordinatesDocAnBounding> staff;
    List<CoordinatesDocAnBounding> title;

    public AutoDocumentAnalysisModel(){}
    public AutoDocumentAnalysisModel(List<CoordinatesDocAnBounding> staff, List<CoordinatesDocAnBounding> title)
    {
        this.staff = staff;
        this.title = title;
    }

    public List<CoordinatesDocAnBounding> getStaff() {
        return staff;
    }

    public void setStaff(List<CoordinatesDocAnBounding> staff) {
        this.staff = staff;
    }

    public List<CoordinatesDocAnBounding> getTitle() {
        return title;
    }

    public void setTitle(List<CoordinatesDocAnBounding> title) {
        this.title = title;
    }
}
