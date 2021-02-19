package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/2/21
 */
public class NumberArray<IdType extends Number> {
    List<IdType> values;

    public NumberArray(List<IdType> idsSequence) {
        this.values = idsSequence;
    }

    public NumberArray() {
        this.values = new ArrayList<>();
    }

    public void add(IdType id) {
        this.values.add(id);
    }

    public List<IdType> getValues() {
        return values;
    }

    public void setValues(List<IdType> idsSequence) {
        this.values = idsSequence;
    }
}
