package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/2/21
 */
public class Ordering<IdType> {
    List<IdType> idsSequence;

    public Ordering(List<IdType> idsSequence) {
        this.idsSequence = idsSequence;
    }

    public Ordering() {
        this.idsSequence = new ArrayList<>();
    }

    public void add(IdType id) {
        this.idsSequence.add(id);
    }

    public List<IdType> getIdsSequence() {
        return idsSequence;
    }

    public void setIdsSequence(List<IdType> idsSequence) {
        this.idsSequence = idsSequence;
    }
}
