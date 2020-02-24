package es.ua.dlsi.grfia.im4.core.semantic;

public class MetronomeMark extends MarkItem {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*MM";

    final int tempo;

    public MetronomeMark(int tempo) {
        super(SKM + tempo);
        this.tempo = tempo;
    }

    public int getTempo() {
        return tempo;
    }

    @Override
    public MetronomeMark clone() {
        return new MetronomeMark(tempo);
    }
}
