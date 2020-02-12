package es.ua.dlsi.grfia.im3ws.muret.controller.payload.alignmentPreview;

import es.ua.dlsi.im3.core.score.Figures;

public class AlignmentPreviewItemWithDuration extends AlignmentPreviewItem {
    Figures figures;
    int dots;
    double duration;

    public Figures getFigures() {
        return figures;
    }

    public void setFigures(Figures figures) {
        this.figures = figures;
    }

    public int getDots() {
        return dots;
    }

    public void setDots(int dots) {
        this.dots = dots;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
