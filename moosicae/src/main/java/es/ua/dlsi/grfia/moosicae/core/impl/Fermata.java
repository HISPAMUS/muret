package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IFermata;
import es.ua.dlsi.grfia.moosicae.core.properties.IFermataShape;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMarkAnchor;
import es.ua.dlsi.grfia.moosicae.core.properties.IVerticalPlace;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Fermata extends Mark implements IFermata {
    private final IVerticalPlace verticalPlace;
    private final IFermataShape fermataShape;

    /**
     * @param id    If id is null, a new id is generated. If not null, the value is assigned
     * @param start
     */
    public Fermata(IId id, @NotNull IMarkAnchor start, IVerticalPlace verticalPlace, IFermataShape fermataShape) {
        super(id, start);
        this.verticalPlace = verticalPlace;
        this.fermataShape = fermataShape;
    }

    @Override
    public Optional<IVerticalPlace> getVerticalPlace() {
        return Optional.ofNullable(verticalPlace);
    }

    @Override
    public Optional<IFermataShape> getFermataShape() {
        return Optional.ofNullable(fermataShape);
    }

    @Override
    public Fermata clone() {
        return new Fermata(null, start, verticalPlace, fermataShape);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportFermata(this, inputOutput);
    }
}
