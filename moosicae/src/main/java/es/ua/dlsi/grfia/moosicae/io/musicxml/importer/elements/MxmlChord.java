package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MxmlChord extends MxmlObject {

    protected MxmlChord(IId id) {
        super(id);
    }

    @Override
    public MxmlChord clone() {
        return new MxmlChord(id);
    }
}
