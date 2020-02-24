package es.ua.dlsi.grfia.im4.core.semantic;

public class MultiMeasureRest extends SemanticItem {
    final int numMeasures;


    public MultiMeasureRest(int numMeasures) {
        super("r-" + numMeasures + "-");
        this.numMeasures = numMeasures;
    }

    public int getNumMeasures() {
        return numMeasures;
    }

    @Override
    public MultiMeasureRest clone() {
        return new MultiMeasureRest(numMeasures);
    }
}
