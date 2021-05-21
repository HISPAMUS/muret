package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBeamGroup;
import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.IVoicedComposite;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.ITie;
import es.ua.dlsi.grfia.moosicae.core.properties.ITieOrientation;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import java.util.Optional;

/**
 * It implements the IMeiSectionItem because, being a subelement of measure, it should be handled at section level (ties may cross measures)
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/5/21
 */
public class MEITie extends MEIObject implements ITie, IMeiSectionItem {
    private final IId startId;
    private final IId endId;

    public MEITie(IId id, IId startId, IId endId) {
        super(id);
        this.startId = startId;
        this.endId = endId;
    }

    public IId getStartId() {
        return startId;
    }

    public IId getEndId() {
        return endId;
    }

    @Override
    public MEITie clone() {
        return new MEITie(null, startId, endId);
    }

    @Override
    public Optional<ITieOrientation> getOrientation() {
        return Optional.empty(); //TODO orientation
    }
}
