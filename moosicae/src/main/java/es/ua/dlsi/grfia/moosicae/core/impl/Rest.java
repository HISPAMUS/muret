package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;



/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Rest extends DurationalSingle implements IRest {
    public Rest(IId id, @NotNull IFigure figure,  IDots dots) {
        super(id, figure, dots);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportRest(this, inputOutput);
    }

    @Override
    public Rest clone() {
        return new Rest(null, figure, dots);
    }

    @Override
    public String toString() {
        return "Rest{} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
