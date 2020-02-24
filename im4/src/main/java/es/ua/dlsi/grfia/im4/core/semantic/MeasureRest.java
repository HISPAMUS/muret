package es.ua.dlsi.grfia.im4.core.semantic;

public class MeasureRest extends SemanticItem {
    public MeasureRest() {
        super("r");
    }

    @Override
    public MeasureRest clone() {
        return new MeasureRest();
    }
}
