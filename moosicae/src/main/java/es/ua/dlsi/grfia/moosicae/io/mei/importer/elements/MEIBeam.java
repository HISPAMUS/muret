package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 17/5/21
 */
public class MEIBeam implements IBeamGroup, IImportable {
    private final IId id;
    List<IVoiced> children;
    List<IVoiced> connected;

    public MEIBeam(IId id) {
        this.id = id;
        this.children = new LinkedList<>();
        this.connected = new LinkedList<>();
    }

    @Override
    public IId getId() {
        return id;
    }

    /**
     * Actually it is not used
     * @return
     */
    @Override
    public MEIBeam clone() {
        throw new UnsupportedOperationException("Unsupported");
    }

    public IVoiced[] getChildren() {
        return children.toArray(new IVoiced[0]);
    }

    /**
     * Add item to the beam group and to the connected items list
     * @param voiced
     */
    @Override
    public void add(IVoiced voiced) {
        addRecursive(voiced, false); // all items and subitems are linked to the beam
        this.children.add(voiced); // MEIImporter will insert the items as they are, either single or composite
    }

    private void addRecursive(IVoiced voiced, boolean addToConnector) { // this is used for the structure <beam><tuplet>...</tuplet></beam>
        if (voiced instanceof IVoicedComposite) { // e.g. a tuplet
            IVoicedComposite composite = (IVoicedComposite) voiced;
            for (IVoiced child: composite.getChildren()) {
                addRecursive(child, true);
            }
        } else {
            this.connected.add(voiced);
            if (addToConnector) { // when we have a <tuplet><beam>, we don't want the note to be added to other connector, it already has one
                voiced.addConnector(this);
            }
        }
    }

    @Override
    public IVoiced[] getConnected() {
        return connected.toArray(new IVoiced[0]);
    }

    private void checkSize() throws IMException {
        if (connected.size() <= 1) {
            throw new IMException("Expected at least 2 elements, and found " + connected.size());
        }
    }
    @Override
    public IVoiced getFirst() throws IMException {
        checkSize();
        return connected.get(0);
    }

    @Override
    public IVoiced getLast() throws IMException {
        checkSize();
        return connected.get(connected.size()-1);
    }
}
