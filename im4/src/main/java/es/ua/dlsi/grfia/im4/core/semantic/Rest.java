package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;

public class Rest extends DurationalSemanticItem {
    /**
     * Used optionally when it has a different position from the default
     * 1 = bottom line, 5 = top line
     */
    Integer linePosition;

    /**
     *
     * @param figure
     * @param dots
     * @param linePosition Optional
     */
    public Rest(Figures figure, int dots, Integer linePosition, Perfection perfection, Fermata fermata, Size size) throws IM4Exception {
        super(null, figure, dots, perfection, fermata, size);
        this.setSkmEncodingJustInConstructor(buildSkmEncoding());
    }

    public Integer getLinePosition() {
        return linePosition;
    }

    public void setLinePosition(Integer linePosition) {
        this.linePosition = linePosition;
    }

    @Override
    public Rest clone() {
        try {
            return new Rest(this.figure, this.dots, linePosition, perfection, fermata, size);
        } catch (IM4Exception e) {
            throw new IM4RuntimeException("Cannot clone rest", e);
        }
    }

    @Override
    protected final String buildSkmEncoding() throws IM4RuntimeException, IM4Exception {
        StringBuilder stringBuilder = new StringBuilder('r');
        stringBuilder.append(super.buildSkmEncoding());

        if (fermata != null) {
            stringBuilder.append(';');
        }

        return stringBuilder.toString();

    }
}
