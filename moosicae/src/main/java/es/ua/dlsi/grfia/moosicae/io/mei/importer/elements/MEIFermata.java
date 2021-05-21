package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import java.util.Optional;

/**
 * It implements the IMeiSectionItem because, being a subelement of measure, it should be handled at section level (ties with several elements in different staves?)
 * It does not implement IFermata because at creation time we don't know who the IId is related to
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/5/21
 */
public class MEIFermata extends MEIMark implements IMeiSectionItem {

    //TODO position and shape

    public MEIFermata(IId id, IId startId) {
        super(id, startId);
    }

    @Override
    public void toMooObject(MEIMark mark, IVoiced voiced) {
        IMark fermata = ICoreAbstractFactory.getInstance().createFermata(getId(), voiced, null, null);
        voiced.addMark(fermata);
    }

    @Override
    public MEIFermata clone() {
        return new MEIFermata(null, getStartId());
    }
}
