package es.ua.dlsi.grfia.im4.core.semantic;

public class Rest extends DurationalSemanticItem {
    /**
     * Used optionally when it has a different position from the default
     * 1 = bottom line, 5 = top line
     */
    Integer linePosition;

    public Rest(Figures figure, int dots) {
        super(figure, dots);
    }

    public Integer getLinePosition() {
        return linePosition;
    }

    public void setLinePosition(Integer linePosition) {
        this.linePosition = linePosition;
    }
}
