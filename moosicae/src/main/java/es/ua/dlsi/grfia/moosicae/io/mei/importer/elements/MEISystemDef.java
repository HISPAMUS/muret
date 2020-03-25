package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public abstract class MEISystemDef extends MEIObject {
    protected MEISystemDef(IId id) {
        super(id);
    }

    @Override
    public String toString() {
        return "MEISystemDef{" +
                "id=" + id +
                "} " + super.toString();
    }
}
