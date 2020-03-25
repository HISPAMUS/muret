package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.List;

/**
 * Part class created just for importing MusicXML files
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MxmlImportedPart extends MxmlObject {
    private final List<IMxmlPartItem> items;

    public MxmlImportedPart(IId id, List<IMxmlPartItem> items) {
        super(id);
        this.items = items;
    }

    public List<IMxmlPartItem> getItems() {
        return items;
    }


    @Override
    public MxmlImportedPart clone() {
        return new MxmlImportedPart(id, items);
    }
}
