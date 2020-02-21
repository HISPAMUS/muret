package es.ua.dlsi.grfia.im4.core.semantic;

public class BarLine extends SemanticItem {
    private final BarlineType barlineType;

    public BarLine(BarlineType barlineType) {
        this.barlineType = barlineType;
    }

    public BarlineType getBarlineType() {
        return barlineType;
    }
}
