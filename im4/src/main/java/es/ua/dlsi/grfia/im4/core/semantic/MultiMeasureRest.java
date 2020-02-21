package es.ua.dlsi.grfia.im4.core.semantic;

public class MultiMeasureRest extends SemanticItem {
    final int numMeasures;


    public MultiMeasureRest(int numMeasures) {
        this.numMeasures = numMeasures;
    }

    public int getNumMeasures() {
        return numMeasures;
    }
}
