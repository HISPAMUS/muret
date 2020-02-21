package es.ua.dlsi.grfia.im4.core.semantic;

import java.util.Objects;

public class DurationalSemanticItem extends SemanticItem {
    final private Figures figure;
    final int dots;
    boolean fermata;
    boolean cueSized;

    public DurationalSemanticItem(Figures figure, int dots) {
        Objects.requireNonNull(figure, "figure");

        this.figure = figure;
        this.dots = dots;
    }

    public Figures getFigure() {
        return figure;
    }

    public int getDots() {
        return dots;
    }

    public boolean isFermata() {
        return fermata;
    }

    public void setFermata(boolean fermata) {
        this.fermata = fermata;
    }

    public boolean isCueSized() {
        return cueSized;
    }

    public void setCueSized(boolean cueSized) {
        this.cueSized = cueSized;
    }
}
