package es.ua.dlsi.grfia.im3ws.muret.entity;

import java.io.Serializable;
import java.util.List;

public abstract class Strokes implements Serializable {
    public abstract List<? extends Stroke> getStrokeList();
    public abstract String toDatabaseString();

}
