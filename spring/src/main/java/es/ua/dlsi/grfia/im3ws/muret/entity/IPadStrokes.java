package es.ua.dlsi.grfia.im3ws.muret.entity;

import java.util.List;

/**
 * TO-DO Read Antonio Pertusa's JSon format
 */
public class IPadStrokes extends Strokes {
    public static final String PREFIX = "I:";

    @Override
    public List<? extends Stroke> getStrokeList() {
        return null;
    }

    @Override
    public String toDatabaseString() {
        return "A" + "TO-DO";
    }
}
