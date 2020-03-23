package es.ua.dlsi.grfia.moosicae.io.musicxml.importer;

import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.IMusicXMLPartItem;

import java.util.List;

/**
 * Part class created just for importing MusicXML files
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MusicXMLImportedPart implements ICoreObject {
    private final List<IMusicXMLPartItem> items;
    private final IId id;

    public MusicXMLImportedPart(IId iid, List<IMusicXMLPartItem> items) {
        this.id = iid;
        this.items = items;
    }

    public List<IMusicXMLPartItem> getItems() {
        return items;
    }

    @Override
    public IId getId() {
        return id;
    }

    @Override
    public ICoreObject clone() {
        return null;
    }
}
